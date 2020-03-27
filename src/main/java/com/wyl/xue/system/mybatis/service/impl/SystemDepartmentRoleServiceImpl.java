package com.wyl.xue.system.mybatis.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.system.mybatis.entity.SystemDepartmentRole;
import com.wyl.xue.system.mybatis.mapper.SystemDepartmentRoleMapper;
import com.wyl.xue.system.mybatis.service.SystemDepartmentRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SystemRoleDepartmentServiceImpl
 * @Function: TODO
 * @Date: 2019/12/18 22:12
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
public class SystemDepartmentRoleServiceImpl extends ServiceImpl<SystemDepartmentRoleMapper, SystemDepartmentRole> implements SystemDepartmentRoleService {}
