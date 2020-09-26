package com.wyl.xue.admin.system.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private Long userId;

    /**
     * 用户名
     */
    private String username;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 密码
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

    /**
     *用户描述
     */
    private String introduction;

    /**
     * 更新版本
     */
    @Version
    private Integer version;

    /**
     * 操作人员
     */
    private String operator;
}
