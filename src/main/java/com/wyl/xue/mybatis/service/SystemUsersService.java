package com.wyl.xue.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.mybatis.entity.SystemUsers;

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
     * @Description 使用用户密码登录
     * @param username 用户名
     * @param password 密码
     * @return java.lang.String
     * @Date 2019/12/22 17:29
     * @Author wangyl
     * @Version V1.0
     */
    String login(String username, String password);

    /**
     * @Description 通过用户ID 获取用户权限
     * @param userId 用户ID
     * @return java.util.List<java.lang.String>
     * @Date 2019/12/22 20:58
     * @Author wangyl
     * @Version V1.0
     */
    Set<String> findPermsByUserId(Integer userId);

}
