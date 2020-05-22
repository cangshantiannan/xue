/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.seckill.mybatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.seckill.mybatis.entity.SeckillProduct;

public interface SeckillProductService extends IService<SeckillProduct> {
    /**
     * @Description 开启活动
     * @param id
     * @return java.lang.Boolean
     * @Date 2020/4/27 23:27
     * @Author wangyl
     * @Version V1.0
     */
    Boolean startSeckillActivity(String id);

    /**
     * @Description 结束活动
     * @param id
     * @return java.lang.Boolean
     * @Date 2020/4/27 23:28
     * @Author wangyl
     * @Version V1.0
     */
    Boolean stopSeckillActivity(String id);

    /**
     * @Description 分页查询所有活动
     * @param page 页数
     * @param size 每页条数
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.wyl.xue.seckill.mybatis.entity.SeckillProduct>
     * @Date 2020/4/27 23:28
     * @Author wangyl
     * @Version V1.0
     */
    IPage<SeckillProduct> getPage(Integer page, Integer size);

    /**
     * @Description 秒杀商品
     * @param userId 用户id
     * @param id 商品id
     * @return java.lang.Boolean
     * @Date 2020/4/27 23:46
     * @Author wangyl
     * @Version V1.0
     */
    Boolean Spike(String userId, String id);
}
