package com.wyl.xue.xuebackground.controller.dingtalk;

import com.taobao.api.ApiException;
import com.wyl.xue.core.dingtalk.DingTalk;
import com.wyl.xue.core.util.result.WebResponse;
import com.wyl.xue.core.util.result.WebResult;
import com.wyl.xue.test.mybatis.entity.Test;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RequestMapping("/v1")
@Api(tags = {"多数据源测试"})
@AllArgsConstructor
@RestController
public class DingTalkController {


    final DingTalk dingTalk;
    @PostMapping(value = "/dingtalk")
    @ApiOperation(value = "测试发送钉钉消息")
    public WebResult<List<Test>> getTest(String msg) {
        try {
            dingTalk.sendText("msg",null);
        }
        catch (ApiException e) {
            e.printStackTrace();
        }
        return WebResponse.WebResponse.ok();
    }



}
