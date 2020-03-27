package com.wyl.xue.system.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.system.mybatis.entity.SystemUsers;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Set;

/**
 * @ClassName: SystemUsersService
 * @Function: 用户信息Service
 * @Date: 2019/12/18 22:08
 * @author wangyl
 * @version V1.0
 */
public interface SystemUsersService extends IService<SystemUsers> {
    /**
     * @Description 通过部门id获取用户信息
     * @param departmentId 部门id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemUsers>
     * @Date 2020/3/27 18:15
     * @Author wangyl
     * @Version  V1.0
     */
    List<SystemUsers> getSystemUsersByDepartmentId(Integer departmentId);
}
