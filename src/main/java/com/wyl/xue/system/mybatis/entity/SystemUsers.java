package com.wyl.xue.system.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName: SystemUsers
 * @Function: 用户信息表
 * @Date: 2019/12/15 23:59
 * @author wangyl
 * @version V1.0
 */
@Data
@Builder
@Accessors(chain = true)
@TableName(value = "system_users")
public class SystemUsers extends Model<SystemUsers> {
    /**
     * 主键ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

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
    private Integer departmentId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phoneNumber;

}