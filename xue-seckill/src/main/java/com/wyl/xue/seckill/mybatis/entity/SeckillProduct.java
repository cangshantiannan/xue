/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.seckill.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Coupon
 * @Function: TODO
 * @Date: 2020/4/27 22:26
 * @author wyl
 * @version V1.0
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "seckill_product")
public class SeckillProduct extends BaseSeckillInformation {
    /**
     * 产品id
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;
    /**
     * 产品名称
     */
    private String productName;

}
