package com.wyl.xue.system.mybatis.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.system.mybatis.entity.SystemRoleMenu;
import com.wyl.xue.system.mybatis.mapper.SystemRoleMenuMapper;
import com.wyl.xue.system.mybatis.service.SystemRoleMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @ClassName: SystemRoleMenuServiceImpl
 * @Function: 角色菜单
 * @Date: 2019/12/18 22:13
 * @author wyl
 * @version V1.0
 */
@Slf4j
@Service
public class SystemRoleMenuServiceImpl extends ServiceImpl<SystemRoleMenuMapper, SystemRoleMenu> implements SystemRoleMenuService {
    /**
     * @Description 通过菜单ID 获取和该菜单有关联的角色列表
     * @param menuId
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemRoleMenu>
     * @Date 2020/4/15 23:10
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public List<SystemRoleMenu> getSystemRoleMenuByMenuId(String menuId) {
        return this.list(Wrappers.<SystemRoleMenu>lambdaQuery().eq(SystemRoleMenu::getMenuId, menuId));
    }

    /**
     * @Description 通过角色ids 获取所有权限
     * @param ids
     * @return java.util.Set<java.lang.String>
     * @Date 2020/4/19 1:44
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public Set<String> getPermByRoleIds(List<String> ids) {
        List<Map<String, String>> permByRolesId = this.baseMapper.getPermByRolesId(ids);
        Set<String> premSet = permByRolesId.parallelStream().map(tmp -> tmp.get("perms")).collect(Collectors.toSet());
        return premSet;
    }
}
