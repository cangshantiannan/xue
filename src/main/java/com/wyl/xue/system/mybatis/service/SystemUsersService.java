package com.wyl.xue.system.mybatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.system.mybatis.entity.SystemUsers;

import java.util.List;

/**
 * @ClassName: SystemUsersService
 * @Function: 用户信息Service
 * @Date: 2019/12/18 22:08
 * @author wangyl
 * @version V1.0
 */
public interface SystemUsersService extends IService<SystemUsers> {
    /**
     * @Description 通过部门id获取用户信息 包括子部门
     * @param departmentId 部门id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemUsers>
     * @Date 2020/3/27 18:15
     * @Author wangyl
     * @Version V1.0
     */
    IPage<SystemUsers> getSystemUsersByDepartmentId(String departmentId, Integer page, Integer size);

    /**
     * @Description 通过部门id获取该部门下的所有用户信息 不包括子部门
     * @param departmentId 部门id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemUsers>
     * @Date 2020/4/12 23:40
     * @Author wangyl
     * @Version V1.0
     */
    List<SystemUsers> getSystemUsersByDepartmentId(String departmentId);

    /**
     * @Description 通过用户id重置用户密码重置密码为123456
     * @param id 用户ID
     * @return java.lang.String
     * @Date 2020/4/13 16:09
     * @Author wangyl
     * @Version V1.0
     */
    String resetPasswordById(String id);

    /**
     * @Description 设置用户的角色信息
     * @param id 用户id
     * @param roleIds 角色id列表
     * @return java.lang.Boolean
     * @Date 2020/4/13 16:35
     * @Author wangyl
     * @Version V1.0
     */
    Boolean setUserRoles(String id, List<String> roleIds);
}

