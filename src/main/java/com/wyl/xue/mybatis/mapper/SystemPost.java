package com.wyl.xue.mybatis.mapper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: SystemPost
 * @Function:  岗位信息表
 * @Date:      2019/12/15 23:57
 * @author     wangyl
 * @version    V1.0
 */ 
@Data
@Builder
@TableName(value = "system_post")
public class SystemPost extends Model<SystemPost> {
    /**
    * 主键
    */
    @TableId(value = "post_id",type = IdType.AUTO)
    private Integer postId;

    /**
    * 岗位名称
    */
    private String postName;

    /**
    * 部门id
    */
    private Integer departmentId;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

}