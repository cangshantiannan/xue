package com.wyl.xue.admin.system.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.admin.system.mybatis.entity.SystemRoleMenu;

import java.util.List;
import java.util.Set;

/**
 * @ClassName: SystemRoleMenuService
 * @Function: 菜单信息Service
 * @Date: 2019/12/18 22:04
 * @author wangyl
 * @version V1.0
 */
public interface SystemRoleMenuService extends IService<SystemRoleMenu> {
    /**
     * @Description 通过菜单ID 获取和该菜单有关联的角色列表
     * @param menuId
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemRoleMenu>
     * @Date 2020/4/15 23:10
     * @Author wangyl
     * @Version V1.0
     */
    List<SystemRoleMenu> getSystemRoleMenuByMenuId(String menuId);

    /**
     * @Description 通过角色ids 获取所有权限
     * @param ids
     * @return java.util.Set<java.lang.String>
     * @Date 2020/4/19 1:44
     * @Author wangyl
     * @Version V1.0
     */
    Set<String> getPermByRoleIds(List<String> ids);

    /**
     * @Description 通过角色ids 获取该角色能访问的菜单
     * @param ids
     * @return java.util.Set<java.lang.String>
     * @Date 2020/5/22 11:08
     * @Author wangyl
     * @Version  V1.0
     */
    Set<String> getMenusByRoleIds(List<String> ids);
}
