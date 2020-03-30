package com.wyl.xue.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.mybatis.entity.SystemRoleMenu;

import java.util.List;

/**
 * @ClassName: SystemRoleMenuService
 * @Function: 菜单信息Service
 * @Date: 2019/12/18 22:04
 * @author wangyl
 * @version V1.0
 */
public interface SystemRoleMenuService extends IService<SystemRoleMenu> {

    /**
     * @Description 角色ID列表 获取菜单列表
     * @param roleIds
     * @return java.util.List<java.lang.Integer>
     * @Date 2019/12/23 11:55
     * @Author wangyl
     * @Version V1.0
     */
    List<Integer> findMenuIdByRoles(List<Integer> roleIds);
}
