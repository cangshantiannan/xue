package com.wyl.xue.system.mybatis.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.system.mybatis.entity.SystemUserRole;
import com.wyl.xue.system.mybatis.entity.SystemUsers;
import com.wyl.xue.system.mybatis.mapper.SystemUsersMapper;
import com.wyl.xue.system.mybatis.service.SystemDepartmentService;
import com.wyl.xue.system.mybatis.service.SystemUserRoleService;
import com.wyl.xue.system.mybatis.service.SystemUsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @ClassName: SystemUsersServiceImpl
 * @Function: TODO
 * @Date: 2019/12/18 22:10
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
@AllArgsConstructor
public class SystemUsersServiceImpl extends ServiceImpl<SystemUsersMapper, SystemUsers> implements SystemUsersService {

    final SystemDepartmentService systemDepartmentService;
    final SystemUserRoleService systemUserRoleService;

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

