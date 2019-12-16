package com.wyl.xue.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
/**
 * @ClassName: SystemUsers
 * @Function:  用户信息表
 * @Date:      2019/12/15 23:59
 * @author     wangyl
 * @version    V1.0
 */
@Data
@Builder
@NoArgsConstructor
@TableName(value = "system_users")
public class SystemUsers extends Model<SystemUsers> {
    /**
    * 主键ID
    */
    @TableId(value = "user_id",type = IdType.AUTO)
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
    * 岗位ID
    */
    private Integer postId;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 手机号
    */
    private String phoneNumber;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 修改时间
    */
    private Date updateTime;

    /**
    * 1-正常，0-锁定
    */
    private Boolean lockFlag;

    /**
    * 1-正常，0-删除
    */
    private Boolean delFlag;

}