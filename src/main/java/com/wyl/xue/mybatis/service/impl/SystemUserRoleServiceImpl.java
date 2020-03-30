/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.mybatis.entity.SystemUserRole;
import com.wyl.xue.mybatis.mapper.SystemUserRoleMapper;
import com.wyl.xue.mybatis.service.SystemUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: SystemUserRoleServiceImpl
 * @Function: TODO
 * @Date: 2019/12/18 22:14
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
public class SystemUserRoleServiceImpl extends ServiceImpl<SystemUserRoleMapper, SystemUserRole> implements SystemUserRoleService {
    @Override
    public List<Integer> findRoleIdByUserId(Integer userId) {
        List<SystemUserRole> systemUserRoleList = this.baseMapper.selectList(new QueryWrapper<>(SystemUserRole.builder().userId(userId).build()));
        List<Integer> roleIds = systemUserRoleList.stream().map(SystemUserRole::getRoleId).collect(Collectors.toList());
        if (log.isDebugEnabled()) {
            log.debug("roleIds is [{}]", roleIds);
        }
        return roleIds;
    }
}
