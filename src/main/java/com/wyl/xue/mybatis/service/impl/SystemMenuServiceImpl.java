/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.mybatis.entity.SystemMenu;
import com.wyl.xue.mybatis.mapper.SystemMenuMapper;
import com.wyl.xue.mybatis.service.SystemMenuService;
import com.wyl.xue.mybatis.service.SystemRoleMenuService;
import com.wyl.xue.mybatis.service.SystemUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Autowired
    SystemUserRoleService systemUserRoleService;
    @Autowired
    SystemRoleMenuService systemRoleMenuService;

    /**
     * @Description 通过用户Id获取菜单信息
     * @param userId
     * @return java.util.List<com.wyl.xue.mybatis.entity.SystemMenu>
     * @Date 2019/12/23 11:40
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public List<SystemMenu> findMenuInfoByUserId(Integer userId) {
        List<Integer> roleIds = systemUserRoleService.findRoleIdByUserId(userId);
        List<Integer> menuIds = systemRoleMenuService.findMenuIdByRoles(roleIds);
        List<SystemMenu> systemMenus = this.findMenuInfoByMenuIds(menuIds);
        if (log.isDebugEnabled()) {
            log.debug("systemMenus is [{}]", systemMenus);
        }
        return systemMenus;
    }

    /**
     * @Description 通过多个菜单Id 获取菜单信息
     * @param menuIds 菜单id
     * @return java.util.List<com.wyl.xue.mybatis.entity.SystemMenu>
     * @Date 2019/12/23 12:59
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public List<SystemMenu> findMenuInfoByMenuIds(List<Integer> menuIds) {
        LambdaQueryWrapper<SystemMenu> systemMenuLambdaQueryWrapper = Wrappers.<SystemMenu>query().lambda();
        systemMenuLambdaQueryWrapper.in(false, SystemMenu::getMenuId, menuIds);
        List<SystemMenu> systemMenus = baseMapper.selectList(systemMenuLambdaQueryWrapper);
        if (log.isDebugEnabled()) {
            log.debug("systemMenus is [{}]", systemMenus);
        }
        return systemMenus;
    }

}
