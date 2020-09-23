/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.seckill.mybatis.entity;

import lombok.Data;

/**
 * @ClassName: BaseActivityInformation
 * @Function: 活动基础信息表 每一个秒杀活动信息 都应该继承该表
 * @Date: 2020/4/25 21:44
 * @author wyl
 * @version V1.0
 */
@Data
public class BaseSeckillInformation implements SeckillInformation {
    /**
     * 活动商品id 唯一值
     */
    private String commodityId;
    /**
     * 活动商品数量
     */
    private Long commodityNumbre;
}
