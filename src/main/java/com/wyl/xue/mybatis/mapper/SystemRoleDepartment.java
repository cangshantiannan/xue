package com.wyl.xue.mybatis.mapper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;

/**
 * <p>
 * 角色与部门对应关系
 * </p>
 *
 * @author lihaodong
 * @since 2019-04-21
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
    private Integer deptId;
}
