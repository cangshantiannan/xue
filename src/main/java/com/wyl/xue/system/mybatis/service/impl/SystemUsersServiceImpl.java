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
    @Override
    public List<SystemUsers> getSystemUsersByDepartmentId(Integer departmentId) {
        return null;
    }
}
