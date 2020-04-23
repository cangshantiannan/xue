package com.wyl.xue.xuebackground.system.mybatis.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.xuebackground.system.mybatis.entity.SystemRoles;

import java.util.List;

/**
 * @ClassName: SystemRolesService
 * @Function: 角色Service
 * @Date: 2019/12/18 22:06
 * @author wangyl
 * @version V1.0
 */
public interface SystemRolesService extends IService<SystemRoles> {

    /**
     * @Description 通过用户ID 获取该用的所有权限
     * @param userId 用户Id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemRoles>
     * @Date 2020/4/13 17:37
     * @Author wangyl
     * @Version V1.0
     */
    List<SystemRoles> getRolesByUserId(String userId);

    /**
     * @Description 分页获取角色信息
     * @param page 页码
     * @param size 条数
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.wyl.xue.system.mybatis.entity.SystemRoles>
     * @Date 2020/4/13 23:08
     * @Author wangyl
     * @Version V1.0
     */
    IPage<SystemRoles> getRolesInfo(Integer page, Integer size);


    /**
     * @Description 设置角色菜单信息
     * @param id 角色ID
     * @param menuIds 菜单列表
     * @return java.lang.Boolean
     * @Date 2020/4/16 22:19
     * @Author wangyl
     * @Version V1.0
     */
    Boolean setRoleMenus(String id, List<String> menuIds);
}
