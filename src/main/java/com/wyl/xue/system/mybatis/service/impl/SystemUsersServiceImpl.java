/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.system.mybatis.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.system.mybatis.entity.SystemUsers;
import com.wyl.xue.system.mybatis.mapper.SystemUsersMapper;
import com.wyl.xue.system.mybatis.service.SystemUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName: SystemUsersServiceImpl
 * @Function: TODO
 * @Date: 2019/12/18 22:10
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
public class SystemUsersServiceImpl extends ServiceImpl<SystemUsersMapper, SystemUsers> implements SystemUsersService {

    /**
     * @Description 通过部门id获取用户信息
     * @param departmentId 部门id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemUsers>
     * @Date 2020/3/27 18:15
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public List<SystemUsers> getSystemUsersByDepartmentId(List<Object> departmentId) {
        List<SystemUsers> systemUsers = this.list(Wrappers.<SystemUsers>lambdaQuery().in(SystemUsers::getDepartmentId, departmentId));
        if (log.isDebugEnabled()) {
            log.debug(systemUsers.toString());
        }
        return systemUsers;
    }
}

