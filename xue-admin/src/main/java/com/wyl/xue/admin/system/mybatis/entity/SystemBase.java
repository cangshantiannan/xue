/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.admin.system.mybatis.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName: SystemBase
 * @Function: 基础表
 * @Date: 2020/4/12 17:08
 * @author wyl
 * @version V1.0
 */
@Data
public class SystemBase implements Serializable {
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime creatTime;
    /**
     *更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    /**
     * 删除标记
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer deleteFlage;

}
