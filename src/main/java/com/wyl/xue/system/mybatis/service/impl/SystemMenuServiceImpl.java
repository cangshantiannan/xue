package com.wyl.xue.system.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.system.mybatis.entity.SystemMenu;
import com.wyl.xue.system.mybatis.mapper.SystemMenuMapper;
import com.wyl.xue.system.mybatis.service.SystemMenuService;
import com.wyl.xue.system.mybatis.service.SystemRoleMenuService;
import com.wyl.xue.system.mybatis.service.SystemUsersService;
import com.wyl.xue.system.vo.MenuTree;
import com.wyl.xue.util.exception.BizException;
import com.wyl.xue.util.result.ResultCode;
import com.wyl.xue.util.tree.TreeUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName: SystemMenuServiceImpl
 * @Function: 菜单
 * @Date: 2019/12/18 22:12
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
@AllArgsConstructor
public class SystemMenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenu> implements SystemMenuService {

    final SystemUsersService systemUsersService;
    final SystemRoleMenuService systemRoleMenuService;

    @Override
    public boolean removeById(Serializable id) {
        List<SystemMenu> systemMenuList = this.list(Wrappers.<SystemMenu>lambdaQuery().eq(SystemMenu::getParentId, id));
        if (systemMenuList.isEmpty() && systemRoleMenuService.getSystemRoleMenuByMenuId(id.toString()).isEmpty()) {
            return super.removeById(id);
        } else {
            log.error("该节点有相关数据无法删除[{}]", id);
            throw new BizException(ResultCode.HAVERESOURCES);
        }
    }

    /**
     * @Description 获取所有非按钮的菜单，组装为树的形式
     * @return java.util.List<com.wyl.xue.system.vo.MenuTree>
     * @Date 2020/4/14 23:42
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public List<MenuTree> getMenuTree() {
        List<SystemMenu> systemMenuList = this.list(Wrappers.<SystemMenu>lambdaQuery().ne(SystemMenu::getType, 2));
        List<MenuTree> menuTreeList = new ArrayList<>();
        systemMenuList.stream().forEach(systemMenu -> {
            MenuTree menuTree = new MenuTree(systemMenu.getMenuId(), systemMenu.getParentId(), systemMenu.getMenuName());
            menuTreeList.add(menuTree);
        });
        return TreeUtil.bulid(menuTreeList, "-1", null);
    }

    /**
     * @Description 通过Id获取该菜单下的所有按钮
     * @param id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemMenu>
     * @Date 2020/4/16 22:54
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public List<SystemMenu> getMenusById(String id) {
        Map<SFunction<SystemMenu, ?>, Object> params = new HashMap<>();
        params.put(SystemMenu::getParentId, id);
        params.put(SystemMenu::getType, 3);
        LambdaQueryWrapper<SystemMenu> systemMenuLambdaQueryWrapper = Wrappers.<SystemMenu>lambdaQuery().allEq(params);
        return this.list(systemMenuLambdaQueryWrapper);
    }
}
