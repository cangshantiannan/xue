package com.wyl.xue.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.mybatis.entity.SystemMenu;

import java.util.List;

/**
 * @ClassName: SystemMenuService
 * @Function: 菜单表Service
 * @Date: 2019/12/18 22:01
 * @author wangyl
 * @version V1.0
 */
public interface SystemMenuService extends IService<SystemMenu> {
    /**
     * @Description 通过用户Id获取菜单信息
     * @param userId
     * @return java.util.List<com.wyl.xue.mybatis.entity.SystemMenu>
     * @Date 2019/12/23 11:40
     * @Author wangyl
     * @Version V1.0
     */
    List<SystemMenu> findMenuInfoByUserId(Integer userId);

    /**
     * @Description 通过多个菜单Id 获取菜单信息
     * @param menuids 菜单id
     * @return java.util.List<com.wyl.xue.mybatis.entity.SystemMenu>
     * @Date 2019/12/23 12:59
     * @Author wangyl
     * @Version V1.0
     */
    List<SystemMenu> findMenuInfoByMenuIds(List<Integer> menuids);

}
