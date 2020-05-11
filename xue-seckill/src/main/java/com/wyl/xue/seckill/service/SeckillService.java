/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.seckill.service;

import com.wyl.xue.seckill.mybatis.entity.SeckillInformation;

import java.io.Serializable;

/**
 * @ClassName: test
 * @Function: TODO
 * @Date: 2020/4/24 22:56
 * @author wyl
 * @version V1.0
 */
public interface SeckillService {
    /**
     * @Description 添加秒杀商品
     * @param baseActivityInformation
     * @return void
     * @Date 2020/4/26 0:17
     * @Author wangyl
     * @Version V1.0
     */
    void addSeckillProduct(SeckillInformation baseActivityInformation);

    /**
     * @Description 抢购秒杀商品
     * @param id
     * @param baseActivityInformation
     * @return void
     * @Date 2020/4/26 0:29
     * @Author wangyl
     * @Version V1.0
     */
    void snappedUpProduct(Serializable id, SeckillInformation baseActivityInformation);

    /**
     * @Description 移除秒杀商品
     * @param baseActivityInformation
     * @return void
     * @Date 2020/4/26 0:17
     * @Author wangyl
     * @Version V1.0
     */
    void removeSeckillProduct(SeckillInformation baseActivityInformation);
}
