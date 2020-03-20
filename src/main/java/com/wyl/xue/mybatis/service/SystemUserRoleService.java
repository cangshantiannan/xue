package com.wyl.xue.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.mybatis.entity.SystemUserRole;
import org.hibernate.validator.constraints.EAN;

import java.util.List;


/**
 * @ClassName: SystemUserRoleService
 * @Function:  菜单角色信息Service
 * @Date:      2019/12/18 22:07
 * @author     wangyl
 * @version    V1.0
 */ 
public interface SystemUserRoleService extends IService<SystemUserRole> {
    /**
     * @Description 通过用户Id 获取角色Id列表
     * @param userId
     * @return java.util.List<java.lang.Integer>
     * @Date 2019/12/23 11:47
     * @Author wangyl
     * @Version  V1.0
     */
    List<Integer> findRoleIdByUserId(Integer userId);
}
