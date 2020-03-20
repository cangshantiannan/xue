package com.wyl.xue.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName: SystemRoleDepartment
 * @Function: 角色与部门对应关系
 * @Date: 2019/12/17 13:57
 * @author wangyl
 * @version V1.0
 */
@Data
@Builder
@TableName("system_role_department")
public class SystemRoleDepartment extends Model<SystemRoleDepartment> {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 部门ID
     */
    private Integer departmentId;
}
