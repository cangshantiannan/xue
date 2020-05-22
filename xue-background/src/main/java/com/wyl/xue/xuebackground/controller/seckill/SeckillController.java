/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.xuebackground.controller.seckill;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyl.xue.core.util.result.WebResponse;
import com.wyl.xue.core.util.result.WebResult;
import com.wyl.xue.seckill.mybatis.entity.SeckillProduct;
import com.wyl.xue.seckill.mybatis.service.SeckillProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: SeckillController
 * @Function: TODO
 * @Date: 2020/4/27 22:18
 * @author wyl
 * @version V1.0
 */
@RestController
@RequestMapping("/v1")
@Api(tags = "商品秒杀接口")
@AllArgsConstructor
public class SeckillController {
    final private SeckillProductService seckillProductService;

    @PostMapping(value = "/seckillActivity")
    @ApiOperation(value = "添加一个秒杀商品")
    public WebResult<Boolean> addSeckillActivity(@RequestBody SeckillProduct seckillProduct) {
        return WebResponse.WebResponse.ok(seckillProductService.save(seckillProduct));
    }

    @PutMapping(value = "/seckillActivity/{id}")
    @ApiOperation(value = "修改秒杀商品信息")
    public WebResult<Boolean> updateSeckillActivity(@RequestBody SeckillProduct seckillProduct) {
        return WebResponse.WebResponse.ok(seckillProductService.updateById(seckillProduct));
    }

    @DeleteMapping(value = "/seckillActivity/{id}")
    @ApiOperation(value = "删除秒杀商品信息")
    public WebResult<Boolean> updateSeckillActivity(@PathVariable String id) {
        return WebResponse.WebResponse.ok(seckillProductService.removeById(id));
    }

    @GetMapping(value = "/seckillActivity/{page}/{size}")
    @ApiOperation(value = "分页获取秒杀商品")
    public WebResult<IPage<SeckillProduct>> getSeckillActivity(@PathVariable Integer page, @PathVariable Integer size) {
        return WebResponse.WebResponse.ok(seckillProductService.getPage(page, size));
    }

    @PostMapping(value = "/start/{id}")
    @ApiOperation(value = "启动秒杀活动")
    public WebResult<Boolean> startSeckillActivity(@PathVariable String id) {
        return WebResponse.WebResponse.ok(seckillProductService.startSeckillActivity(id));
    }

    @PostMapping(value = "/stop/{id}")
    @ApiOperation(value = "停止秒杀活动")
    public WebResult<Boolean> stopSeckillActivity(@PathVariable String id) {
        return WebResponse.WebResponse.ok(seckillProductService.stopSeckillActivity(id));
    }

    @GetMapping(value = "/Spike/{userId}/{SeckillId}")
    @ApiOperation(value = "秒杀")
    public WebResult<Boolean> stopSeckillActivity(@PathVariable String userId, @PathVariable String SeckillId) {
        return WebResponse.WebResponse.ok(seckillProductService.Spike(userId, SeckillId));
    }

    @GetMapping(value = "/Spike/{SeckillId}")
    @ApiOperation(value = "秒杀测试")
    public WebResult<Boolean> stopSeckillActivityTest(@PathVariable String SeckillId) {
        return WebResponse.WebResponse.ok(seckillProductService.Spike(IdUtil.simpleUUID(), SeckillId));
    }

}
