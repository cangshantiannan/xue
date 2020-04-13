package com.wyl.xue.system.mybatis.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.system.mybatis.entity.SystemRoleMenu;
import com.wyl.xue.system.mybatis.entity.SystemRoles;
import com.wyl.xue.system.mybatis.mapper.SystemRolesMapper;
import com.wyl.xue.system.mybatis.service.SystemRoleMenuService;
import com.wyl.xue.system.mybatis.service.SystemRolesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: SystemRolesServiceImpl
 * @Function: TODO
 * @Date: 2019/12/18 22:14
 * @author wyl
 * @version V1.0
 */
@Service
@AllArgsConstructor
@Slf4j
public class SystemRolesServiceImpl extends ServiceImpl<SystemRolesMapper, SystemRoles> implements SystemRolesService {
    final SystemRoleMenuService systemRoleMenuService;

    @Override
    @Transient
    public boolean removeById(Serializable id) {
        systemRoleMenuService.remove(Wrappers.<SystemRoleMenu>lambdaQuery().eq(SystemRoleMenu::getRoleId, id));
        return super.removeById(id);
    }

    @Override
    public List<SystemRoles> getRolesByUserId(String userId) {
        return null;
    }
}
