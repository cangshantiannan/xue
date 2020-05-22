/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.seckill.mybatis.entity;

/**
 * @ClassName: SeckillInformation
 * @Function: 秒杀商品的基础接口
 * @Date: 2020/4/27 23:50
 * @author wangyl
 * @version V1.0
 */
public interface SeckillInformation {
    /**
     * @Description 获取商品Id
     * @param
     * @return java.lang.String
     * @Date 2020/4/27 23:37
     * @Author wangyl
     * @Version V1.0
     */
    String getCommodityId();

    /**
     * @Description 获取商品数量
     * @param
     * @return java.lang.Long
     * @Date 2020/4/27 23:37
     * @Author wangyl
     * @Version V1.0
     */
    Long getCommodityNumbre();
}
