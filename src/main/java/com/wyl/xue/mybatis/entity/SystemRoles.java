package com.wyl.xue.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @ClassName: SystemRoles
 * @Function:  角色信息表
 * @Date:      2019/12/15 23:58
 * @author     wangyl
 * @version    V1.0
 */
@Data
@Builder
@TableName(value = "system_roles")
public class SystemRoles extends Model<SystemRoles> {
    /**
    * 角色主键
    */
    @TableId(value = "role_id",type = IdType.AUTO)
    private Integer roleId;

    /**
    * 角色名称
    */
    private String roleName;

    /**
    * 角色标识
    */
    private String roleCode;

    /**
    * 角色描述
    */
    private String roleDescription;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 删除标识（1-正常,0-删除）
    */
    private Boolean delFlag;

}