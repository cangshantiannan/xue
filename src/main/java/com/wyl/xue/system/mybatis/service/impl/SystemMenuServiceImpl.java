package com.wyl.xue.system.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.system.mybatis.entity.SystemMenu;
import com.wyl.xue.system.mybatis.mapper.SystemMenuMapper;
import com.wyl.xue.system.mybatis.service.SystemMenuService;
import com.wyl.xue.system.vo.MenuTree;
import com.wyl.xue.util.tree.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: SystemMenuServiceImpl
 * @Function: TODO
 * @Date: 2019/12/18 22:12
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
public class SystemMenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenu> implements SystemMenuService {
    @Override
    public List<MenuTree> getMenuTree() {
        List<SystemMenu> systemMenuList = this.list();
        List<MenuTree> menuTreeList = new ArrayList<>();
        systemMenuList.stream().forEach(systemMenu -> {
            MenuTree menuTree = new MenuTree(systemMenu.getMenuId(), systemMenu.getParentId(), systemMenu.getMenuName());
            menuTreeList.add(menuTree);
        });
        return TreeUtil.bulid(menuTreeList, "-1", null);
    }
}
