package com.wyl.xue.admin.system.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.admin.system.mybatis.entity.SystemUserRole;
import com.wyl.xue.admin.system.mybatis.mapper.SystemUserRoleMapper;
import com.wyl.xue.admin.system.mybatis.service.SystemUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: SystemUserRoleServiceImpl
 * @Function: 用户角色
 * @Date: 2019/12/18 22:12
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
@DS("master")
public class SystemUserRoleServiceImpl extends ServiceImpl<SystemUserRoleMapper, SystemUserRole> implements SystemUserRoleService {

    /**
     * @Description 通过用户id获取该用的角色列表
     * @param userId
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemUserRole>
     * @Date 2020/4/19 1:21
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public List<SystemUserRole> getSystemUserRoleByUserId(Long userId) {
        return this.list(Wrappers.<SystemUserRole>lambdaQuery().eq(SystemUserRole::getUserId, userId));
    }
}
