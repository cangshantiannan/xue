package com.wyl.xue.system.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.security.UserInfoJwt;
import com.wyl.xue.security.user.SecurityUserInfo;
import com.wyl.xue.system.mybatis.entity.SystemRoles;
import com.wyl.xue.system.mybatis.entity.SystemUserRole;
import com.wyl.xue.system.mybatis.entity.SystemUsers;
import com.wyl.xue.system.mybatis.mapper.SystemUsersMapper;
import com.wyl.xue.system.mybatis.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


/**
 * @ClassName: SystemUsersServiceImpl
 * @Function: 用户
 * @Date: 2019/12/18 22:10
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
public class SystemUsersServiceImpl extends ServiceImpl<SystemUsersMapper, SystemUsers> implements SystemUsersService {

    /**
     * 会有循环依赖问题
     */
    @Autowired
    @Lazy
    SystemDepartmentService systemDepartmentService;

    @Autowired
    @Lazy
    SystemUserRoleService systemUserRoleService;


    @Autowired
    @Lazy
    SystemRolesService systemRolesService;

    @Autowired
    @Lazy
    SystemRoleMenuService systemRoleMenuService;
    @Autowired
    @Lazy
    AuthenticationManager authenticationManager;

    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;

    /**
     * @Description 通过部门id获取该部门下的所有用户 包含子部门
     * @param departmentId 部门id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemUsers>
     * @Date 2020/3/27 18:15
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public IPage<SystemUsers> getSystemUsersByDepartmentId(String departmentId, Integer page, Integer size) {
        List<Object> departmentIds = systemDepartmentService.getDepartmentTreeById(departmentId);
        Page<SystemUsers> pageInfo = new Page<>(page, size);
        IPage<SystemUsers> systemUsers = this.page(pageInfo, Wrappers.<SystemUsers>lambdaQuery().in(SystemUsers::getDepartmentId, departmentIds));
        if (log.isDebugEnabled()) {
            log.debug("部门列表为[{}],用户为[{}]", departmentIds, systemUsers.toString());
        }
        return systemUsers;
    }

    /**
     * @Description 通过部门id获取该部门下的所有用户信息 不包括子部门
     * @param departmentId 部门id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemUsers>
     * @Date 2020/4/12 23:40
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public List<SystemUsers> getSystemUsersByDepartmentId(String departmentId) {
        List<SystemUsers> systemUsers = this.list(Wrappers.<SystemUsers>lambdaQuery().eq(SystemUsers::getDepartmentId, departmentId));
        if (log.isDebugEnabled()) {
            log.debug(systemUsers.toString());
        }
        return systemUsers;
    }

    /**
     * @Description 通过用户id重置用户密码重置密码为123456
     * @param id 用户ID
     * @return java.lang.String
     * @Date 2020/4/13 16:09
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public String resetPasswordById(String id) {
        SystemUsers systemUsers = this.getById(id);
        systemUsers.setPassword("123456");
        this.updateById(systemUsers);
        return systemUsers.getPassword();
    }

    /**
     * @Description 设置用户的角色信息
     * @param id
     * @param roleIds
     * @return java.lang.Boolean
     * @Date 2020/4/13 16:35
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public Boolean setUserRoles(String id, List<String> roleIds) {
        /**
         *用户角色表处理 先删除数据 再重新增加
         */
        systemUserRoleService.remove(Wrappers.<SystemUserRole>lambdaQuery().eq(SystemUserRole::getUserId, id));
        List<SystemUserRole> systemUserRoleList = roleIds.parallelStream().map(roleid -> SystemUserRole.builder().roleId(roleid).UserId(id).build()).collect(Collectors.toList());
        return systemUserRoleService.saveBatch(systemUserRoleList);
    }

    /**
     * @Description 通过用户名获取用户信息
     * @param name
     * @return com.wyl.xue.system.mybatis.entity.SystemUsers
     * @Date 2020/4/18 0:16
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public SystemUsers getSystemUser(String name) {
        LambdaQueryWrapper<SystemUsers> systemUsersLambdaQueryWrapper = Wrappers.<SystemUsers>lambdaQuery().eq(SystemUsers::getUsername, name);
        return this.getOne(systemUsersLambdaQueryWrapper);
    }

    /**
     * @Description 通过用户ID 获取用户权限
     * @param userId
     * @return java.util.Set<java.lang.String>
     * @Date 2020/4/18 0:27
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public Set<String> getSystemPermissions(String userId) {
        List<SystemRoles> rolesList = systemRolesService.getRolesByUserId(userId);
        List<String> roles = rolesList.parallelStream().map(SystemRoles::getId).collect(Collectors.toList());
        if (roles.isEmpty()) {
            return new TreeSet<>();
        } else {
            Set<String> permSet = rolesList.parallelStream().map(SystemRoles::getRoleCode).collect(Collectors.toSet());
            permSet.addAll(systemRoleMenuService.getPermByRoleIds(roles));
            return permSet;
        }
    }

    /**
     * @Description 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return java.lang.String
     * @Date 2020/4/18 23:59
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public String login(String userName, String password) {
        //用户验证
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //生成token
        SecurityUserInfo userDetail = (SecurityUserInfo) authentication.getPrincipal();
        return UserInfoJwt.generateUserInfoToken(userDetail.getUsername(), userDetail.getAuthorities(), userDetail.getUserId());
    }

    @Override
    public boolean save(SystemUsers entity) {
        String password = entity.getPassword();
        entity.setPassword(passwordEncoder.encode(password));
        return super.save(entity);
    }

    @Override
    public boolean updateById(SystemUsers entity) {
        String password = entity.getPassword();
        entity.setPassword(passwordEncoder.encode(password));
        return super.updateById(entity);
    }

    @Override
    @Transient
    public boolean removeById(Serializable id) {
        /**
         *删除用户角色表中个该用户有有关的数据
         */
        systemUserRoleService.remove(Wrappers.<SystemUserRole>lambdaQuery().eq(SystemUserRole::getUserId, id));
        return super.removeById(id);
    }
}

