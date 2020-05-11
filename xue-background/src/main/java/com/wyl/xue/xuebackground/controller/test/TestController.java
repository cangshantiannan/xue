/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.xuebackground.controller.test;

import com.wyl.xue.core.util.result.WebResponse;
import com.wyl.xue.core.util.result.WebResult;
import com.wyl.xue.seckill.service.SeckillService;
import com.wyl.xue.test.mybatis.entity.Test;
import com.wyl.xue.test.mybatis.impl.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1")
@Api(tags = {"多数据源测试"})
@AllArgsConstructor
@RestController
public class TestController {

    final private TestService testService;
    final private SeckillService seckillService;

    @PostMapping(value = "/test")
    @ApiOperation(value = "测试添加", notes = "添加部门接口")
    public WebResult<Boolean> addTest(@RequestBody Test test) {
        return WebResponse.WebResponse.ok(testService.save(test));
    }

    @GetMapping(value = "/test")
    @ApiOperation(value = "测试添加", notes = "添加部门接口")
    public WebResult<List<Test>> getTest() {
        return WebResponse.WebResponse.ok(testService.list());
    }

    @GetMapping(value = "/test1")
    @ApiOperation(value = "测试添加", notes = "添加部门接口")
    public void getTest1() {
        testService.test();
    }

}
