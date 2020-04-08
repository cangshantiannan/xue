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
    List<MenuTree> getMenuTree();
}
