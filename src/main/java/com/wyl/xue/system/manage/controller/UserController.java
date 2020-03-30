/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.system.manage.controller;

import com.wyl.xue.mybatis.entity.SystemUsers;
import com.wyl.xue.mybatis.service.SystemUsersService;
import com.wyl.xue.util.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: UserController
 * @Function: 用户接口
 * @Date: 2019/12/22 17:26
 * @author wyl
 * @version V1.0
 */
@Controller
@RequestMapping("/v1")
@Api(value = "用户接口")
public class UserController {

    @Autowired
    private SystemUsersService systemUsersService;

    @ApiOperation(value = "用户登录接口", notes = "返回的token需要填写到相关请求头中")
    @PostMapping(value = "/login")
    @ResponseBody
    public WebResult login(String username, String password, HttpServletRequest request) {
        return WebResult.ok(systemUsersService.login(username, password));
    }

    @ApiOperation(value = "用户新增接口", notes = "新建一个用户")
    @PostMapping(value = "/user")
    @ResponseBody
    public WebResult addUser(@RequestBody SystemUsers userInfo) {
        if (userInfo.insert()) {
            return WebResult.ok(1);
        }
        return WebResult.error("数据插入失败");
    }

    @ApiOperation(value = "用户更新接口", notes = "返回的token需要填写到相关请求头中")
    @PutMapping(value = "/user")
    @ResponseBody
    public WebResult changeUser(@RequestBody SystemUsers userInfo) {
        if (userInfo.updateById()) {
            return WebResult.ok(1);
        }
        return WebResult.error("更新失败");
    }

    @ApiOperation(value = "用户删除接口", notes = "返回的token需要填写到相关请求头中")
    @DeleteMapping(value = "/user/{id}")
    @ResponseBody
    public WebResult deleteUser(@PathVariable Integer id) {
        if (systemUsersService.removeById(id)) {
            return WebResult.ok(1);
        }
        return WebResult.error("数据删除失败");
    }
}
