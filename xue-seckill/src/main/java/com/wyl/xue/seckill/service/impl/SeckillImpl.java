/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.seckill.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.wyl.xue.core.util.exception.BizException;
import com.wyl.xue.seckill.constant.RedisConstant;
import com.wyl.xue.seckill.mybatis.entity.SeckillInformation;
import com.wyl.xue.seckill.service.SeckillService;
import io.lettuce.core.TransactionResult;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @ClassName: test
 * @Function: TODO
 * @Date: 2020/4/24 22:56
 * @author wyl
 * @version V1.0
 */
@Service
@DS("slave_1")
@Slf4j
public class SeckillImpl implements SeckillService {
    private final StatefulRedisConnection<String, String> connection;

    public SeckillImpl(@Qualifier("singleRedisConnection") StatefulRedisConnection<String, String> connection) {this.connection = connection;}

    /**
     * @Description 添加秒杀商品
     * @param baseActivityInformation
     * @return void
     * @Date 2020/4/26 0:17
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public void addSeckillProduct(SeckillInformation baseActivityInformation) {
        RedisCommands<String, String> sync = connection.sync();
        String commodityId = RedisConstant.SECKILL + baseActivityInformation.getCommodityId();
        Long exists = sync.exists(baseActivityInformation.getCommodityId());
        if (exists > 0) {
            sync.del(commodityId);
        }
        sync.set(commodityId, baseActivityInformation.getCommodityNumbre().toString());
    }

    /**
     * @Description 抢购秒杀商品
     * @param id
     * @param baseActivityInformation
     * @return void
     * @Date 2020/4/26 0:29
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public void snappedUpProduct(Serializable id, SeckillInformation baseActivityInformation) {
        RedisCommands<String, String> sync = connection.sync();
        String commodityId = RedisConstant.SECKILL + baseActivityInformation.getCommodityId();
        sync.watch(commodityId);
        String RemainingNumber = sync.get(commodityId);
        Long number = Long.valueOf(RemainingNumber);
        if (number > 0) {
            sync.multi();
            sync.incrby(commodityId, -1);
            TransactionResult result = sync.exec();
            if (result.wasDiscarded()) {
                throw new BizException("慢了,抢购失败,请重试");
            }
            if (log.isDebugEnabled()) {
                log.debug("用户[{}]秒杀成功,剩余[{}]", id, result.get(0));
            }
        } else {
            throw new BizException("商品已抢购完");
        }
    }

    /**
     * @Description 移除秒杀商品
     * @param baseActivityInformation
     * @return void
     * @Date 2020/4/26 0:17
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public void removeSeckillProduct(SeckillInformation baseActivityInformation) {
        RedisCommands<String, String> sync = connection.sync();
        String commodityId = RedisConstant.SECKILL + baseActivityInformation.getCommodityId();
        Long exists = sync.exists(commodityId);
        if (exists > 0) {
            sync.del(commodityId);
        }
    }
}
