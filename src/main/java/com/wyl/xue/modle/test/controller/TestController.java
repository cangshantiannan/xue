/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.modle.test.controller;

import com.wyl.xue.modle.test.mybatis.entity.Test;
import com.wyl.xue.modle.test.mybatis.service.TestService;
import com.wyl.xue.util.result.WebResponse;
import com.wyl.xue.util.result.WebResult;
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

}
