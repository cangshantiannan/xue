package com.wyl.xue.admin.system.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.admin.system.mybatis.entity.SystemUserRole;
import com.wyl.xue.admin.system.mybatis.mapper.SystemRolesMapper;
import com.wyl.xue.admin.system.mybatis.service.SystemRoleMenuService;
import com.wyl.xue.admin.system.mybatis.service.SystemRolesService;
import com.wyl.xue.admin.system.mybatis.service.SystemUserRoleService;
import com.wyl.xue.core.util.exception.BizException;
import com.wyl.xue.core.util.result.ResultCode;
import com.wyl.xue.admin.system.mybatis.entity.SystemRoleMenu;
import com.wyl.xue.admin.system.mybatis.entity.SystemRoles;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: SystemRolesServiceImpl
 * @Function: 角色
 * @Date: 2019/12/18 22:14
 * @author wyl
 * @version V1.0
 */
@Service
@AllArgsConstructor
@Slf4j
@DS("master")
public class SystemRolesServiceImpl extends ServiceImpl<SystemRolesMapper, SystemRoles> implements SystemRolesService {
    final SystemRoleMenuService systemRoleMenuService;
    final SystemUserRoleService systemUserRoleService;


    @Override
    @Transient
    public boolean removeById(Serializable id) {
        if (systemUserRoleService.list(Wrappers.<SystemUserRole>lambdaQuery().eq(SystemUserRole::getRoleId, id)).isEmpty()) {
            /**
             *删除菜单角色关联
             */
            systemRoleMenuService.remove(Wrappers.<SystemRoleMenu>lambdaQuery().eq(SystemRoleMenu::getRoleId, id));
            return super.removeById(id);
        }
        log.error("该节点ID[{}]还有先关资源没有被删除", id.toString());
        throw new BizException(ResultCode.HAVERESOURCES);
    }

    /**
     * @Description 通过用户ID 获取该用的所有权限
     * @param userId 用户Id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemRoles>
     * @Date 2020/4/13 17:37
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public List<SystemRoles> getRolesByUserId(String userId) {
        List<SystemUserRole> systemUserRoles = systemUserRoleService.list(Wrappers.<SystemUserRole>lambdaQuery().eq(SystemUserRole::getUserId, userId));
        List<String> roleIds = systemUserRoles.parallelStream().map(SystemUserRole::getRoleId).collect(Collectors.toList());
        return listByIds(roleIds);
    }

    /**
     * @Description 分页获取角色信息
     * @param page 页码
     * @param size 条数
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.wyl.xue.system.mybatis.entity.SystemRoles>
     * @Date 2020/4/13 23:08
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public IPage<SystemRoles> getRolesInfo(Integer page, Integer size) {
        Page<SystemRoles> pageInfo = new Page<>(page, size);
        return page(pageInfo);
    }

    /**
     * @Description 设置角色菜单信息
     * @param id 角色ID
     * @param menuIds 菜单列表
     * @return java.lang.Boolean
     * @Date 2020/4/16 22:19
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public Boolean setRoleMenus(String id, List<String> menuIds) {
        systemRoleMenuService.remove(Wrappers.<SystemRoleMenu>lambdaQuery().eq(SystemRoleMenu::getRoleId, id));
        List<SystemRoleMenu> systemRoleMenus = menuIds.parallelStream().map(menuId -> SystemRoleMenu.builder().menuId(menuId).roleId(id).build()).collect(Collectors.toList());
        return systemRoleMenuService.saveBatch(systemRoleMenus);
    }
}
