package com.wyl.xue.system.controller;

import com.wyl.xue.system.mybatis.entity.SystemUsers;
import com.wyl.xue.system.mybatis.service.SystemUsersService;
import com.wyl.xue.util.result.ResultCode;
import com.wyl.xue.util.result.WebResponse;
import com.wyl.xue.util.result.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName: UserController
 * @Function: 用户接口
 * @Date: 2019/12/22 17:26
 * @author wyl
 * @version V1.0
 */
@Controller
@RequestMapping("/v1")
@Api(tags = {"用户信息接口"})
@AllArgsConstructor
public class UserController {

    private final SystemUsersService systemUsersService;


    @ApiOperation(value = "用户登录接口", notes = "返回的token需要填写到相关请求头中")
    @PostMapping(value = "/login")
    @ResponseBody
    public WebResult<String> login(String username, String password) {
        return WebResponse.WebResponse.ok("");
    }

    @ApiOperation(value = "用户新增接口", notes = "新建一个用户")
    @PostMapping(value = "/user")
    @ResponseBody
    public WebResult addUser(@RequestBody SystemUsers userInfo) {
        if (systemUsersService.save(userInfo)) {
            return WebResponse.WebResponse.ok();
        }
        return WebResponse.WebResponse.error(ResultCode.DATAINSERTERROR);
    }

    @ApiOperation(value = "用户更新接口", notes = "更新用户的信息")
    @PutMapping(value = "/user")
    @ResponseBody
    public WebResult changeUser(@RequestBody SystemUsers userInfo) {
        if (systemUsersService.updateById(userInfo)) {
            return WebResponse.WebResponse.ok();
        }
        return WebResponse.WebResponse.error(ResultCode.DATAINSERTERROR);
    }

    @ApiOperation(value = "用户删除接口", notes = "根据用户ID删除用户")
    @DeleteMapping(value = "/user/{id}")
    @ResponseBody
    public WebResult deleteUser(@PathVariable String id) {
        SystemUsers users = SystemUsers.builder().userId(id).build();
        if (systemUsersService.removeById(id)) {
            return WebResponse.WebResponse.ok();
        }
        return WebResponse.WebResponse.error(ResultCode.DATAINSERTERROR);
    }

    @ApiOperation(value = "查询用户信息", notes = "根据用户ID查询用户信息")
    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public WebResult getUserInfo(@PathVariable String id) {
        try {
            SystemUsers systemUsers = systemUsersService.getById(id);
            return WebResponse.WebResponse.ok(systemUsers);
        }
        catch (Exception e) {
            return WebResponse.WebResponse.error(e);
        }
    }

    @ApiOperation(value = "根据部门ID获取用户列表", notes = "根据部门ID获取用户列表")
    @GetMapping(value = "/user/{departmentId}")
    @ResponseBody
    public WebResult UserInfoListByDepartment(@PathVariable Integer departmentId) {
        return null;
    }

}
