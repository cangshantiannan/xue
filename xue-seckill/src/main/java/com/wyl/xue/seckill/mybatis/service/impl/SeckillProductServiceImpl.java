/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.seckill.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.seckill.mybatis.entity.SeckillProduct;
import com.wyl.xue.seckill.mybatis.mapper.SeckillProductMapper;
import com.wyl.xue.seckill.mybatis.service.SeckillProductService;
import com.wyl.xue.seckill.service.SeckillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @ClassName: SeckillProductServiceImpl
 * @Function: TODO
 * @Date: 2020/4/27 22:47
 * @author wyl
 * @version V1.0
 */
@Service
@AllArgsConstructor
@DS("slave_1")
public class SeckillProductServiceImpl extends ServiceImpl<SeckillProductMapper, SeckillProduct> implements SeckillProductService {

    final private SeckillService seckillService;

    /**
     * @Description 开启活动
     * @param id
     * @return java.lang.Boolean
     * @Date 2020/4/27 23:27
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public Boolean startSeckillActivity(String id) {
        SeckillProduct byId = this.getById(id);
        seckillService.addSeckillProduct(byId);
        return true;
    }

    /**
     * @Description 结束活动
     * @param id
     * @return java.lang.Boolean
     * @Date 2020/4/27 23:28
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public Boolean stopSeckillActivity(String id) {
        SeckillProduct byId = this.getById(id);
        seckillService.removeSeckillProduct(byId);
        return true;
    }

    /**
     * @Description 分页查询所有活动
     * @param page 页数
     * @param size 每页条数
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.wyl.xue.seckill.mybatis.entity.SeckillProduct>
     * @Date 2020/4/27 23:28
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public IPage<SeckillProduct> getPage(Integer page, Integer size) {
        Page<SeckillProduct> pageInfo = new Page<>(page, size);
        return page(pageInfo);
    }

    /**
     * @Description 秒杀商品
     * @param userId 用户id
     * @param id 商品id
     * @return java.lang.Boolean
     * @Date 2020/4/27 23:46
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public Boolean Spike(String userId, String id) {
        SeckillProduct byId = this.getById(id);
        seckillService.snappedUpProduct(userId, byId);
        return true;
    }

    @Override
    public boolean removeById(Serializable id) {
        this.stopSeckillActivity(id.toString());
        return super.removeById(id);
    }
}
