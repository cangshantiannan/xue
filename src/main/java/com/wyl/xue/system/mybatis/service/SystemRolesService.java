package com.wyl.xue.system.mybatis.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.system.mybatis.entity.SystemRoles;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: SystemRolesService
 * @Function: 角色Service
 * @Date: 2019/12/18 22:06
 * @author wangyl
 * @version V1.0
 */
public interface SystemRolesService extends IService<SystemRoles> {

    /**
     * @Description 通过用户ID 获取该用的所有权限
     * @param userId 用户Id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemRoles>
     * @Date 2020/4/13 17:37
     * @Author wangyl
     * @Version V1.0
     */
    List<SystemRoles> getRolesByUserId(String userId);
}
