package com.wyl.xue.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName: SystemUserRole
 * @Function: 用户角色信息表
 * @Date: 2019/12/18 0:29
 * @author wangyl
 * @version V1.0
 */
@Data
@Builder
@TableName("system_user_role")
public class SystemUserRole extends Model<SystemUserRole> {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

}
