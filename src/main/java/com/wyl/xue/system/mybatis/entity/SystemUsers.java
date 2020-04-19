package com.wyl.xue.system.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName: SystemUsers
 * @Function: 用户信息表
 * @Date: 2019/12/15 23:59
 * @author wangyl
 * @version V1.0
 */
@Data
@Builder
@TableName(value = "system_users")
public class SystemUsers extends SystemBase {
    /**
     * 主键ID
     */
    @TableId(value = "user_id", type = IdType.ASSIGN_UUID)
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 部门ID
     */
    private String departmentId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phoneNumber;

}
