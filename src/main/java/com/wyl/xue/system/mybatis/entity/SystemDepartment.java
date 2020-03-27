package com.wyl.xue.system.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

/**
 * @ClassName: SystemDepartment
 * @Function: 部门表
 * @Date: 2019/12/15 23:55
 * @author wangyl
 * @version V1.0
 */
@Data
@Builder
@TableName(value = "system_department")
public class SystemDepartment extends Model<SystemDepartment> {
    /**
     * 部门主键ID
     */
    @TableId(value = "department_id", type = IdType.AUTO)
    private Integer departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 是否删除  0：已删除  1：正常
     */
    private Boolean delFlag;

    /**
     * 上级部门
     */
    private Integer parentId;

}