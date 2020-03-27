package com.wyl.xue.system.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.system.mybatis.entity.SystemRoles;
import com.wyl.xue.system.mybatis.mapper.SystemRolesMapper;
import com.wyl.xue.system.mybatis.service.SystemRolesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SystemRolesServiceImpl
 * @Function: TODO
 * @Date: 2019/12/18 22:14
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
public class SystemRolesServiceImpl extends ServiceImpl<SystemRolesMapper, SystemRoles> implements SystemRolesService {}
