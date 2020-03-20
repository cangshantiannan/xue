/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.mybatis.entity.SystemRoleMenu;
import com.wyl.xue.mybatis.mapper.SystemRoleMenuMapper;
import com.wyl.xue.mybatis.service.SystemRoleMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: SystemRoleMenuServiceImpl
 * @Function: TODO
 * @Date: 2019/12/18 22:13
 * @author wyl
 * @version V1.0
 */
@Slf4j
@Service
public class SystemRoleMenuServiceImpl extends ServiceImpl<SystemRoleMenuMapper, SystemRoleMenu> implements SystemRoleMenuService {
    @Override
    public List<Integer> findMenuIdByRoles(List<Integer> roleIds) {
        if (roleIds.size() == 0) {
            return new ArrayList<Integer>();
        }
        LambdaQueryWrapper<SystemRoleMenu> systemRoleMenuLambdaQueryWrapper = Wrappers.<SystemRoleMenu>query().lambda();
        systemRoleMenuLambdaQueryWrapper.select(SystemRoleMenu::getMenuId).in(false, SystemRoleMenu::getRoleId, roleIds);
        List<SystemRoleMenu> systemRoleMenus = this.baseMapper.selectList(systemRoleMenuLambdaQueryWrapper);
        List<Integer> menuIds = systemRoleMenus.stream().map(SystemRoleMenu::getMenuId).collect(Collectors.toList());
        if (log.isDebugEnabled()) {
            log.debug("menuIds is [{}]", menuIds);
        }
        return menuIds;
    }
}
