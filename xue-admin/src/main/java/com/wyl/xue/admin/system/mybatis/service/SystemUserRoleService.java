package com.wyl.xue.admin.system.mybatis.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.admin.system.mybatis.entity.SystemUserRole;

import java.util.List;

/**
 * @ClassName: SystemUserRoleService
 * @Function: 部门和角色表Service
 * @Date: 2019/12/18 22:03
 * @author wangyl
 * @version V1.0
 */
public interface SystemUserRoleService extends IService<SystemUserRole> {
    /**
     * @Description 通过用户id获取该用的角色列表
     * @param userId
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemUserRole>
     * @Date 2020/4/19 1:21
     * @Author wangyl
     * @Version V1.0
     */
    List<SystemUserRole> getSystemUserRoleByUserId(String userId);
}
