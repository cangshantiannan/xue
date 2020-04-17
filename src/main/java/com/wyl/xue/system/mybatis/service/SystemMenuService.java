package com.wyl.xue.system.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.system.mybatis.entity.SystemMenu;
import com.wyl.xue.system.vo.MenuTree;

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
     * @Description 获取所有非按钮的菜单，组装为树的形式
     * @param
     * @return java.util.List<com.wyl.xue.system.vo.MenuTree>
     * @Date 2020/4/14 23:42
     * @Author wangyl
     * @Version V1.0
     */
    List<MenuTree> getMenuTree();

    /**
     * @Description 通过Id获取该菜单下的所有按钮
     * @param id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemMenu>
     * @Date 2020/4/16 22:54
     * @Author wangyl
     * @Version V1.0
     */
    List<SystemMenu> getMenusById(String id);
}
