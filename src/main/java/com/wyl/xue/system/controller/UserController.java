package com.wyl.xue.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyl.xue.system.mybatis.entity.SystemUsers;
import com.wyl.xue.system.mybatis.service.SystemUsersService;
import com.wyl.xue.util.result.WebResponse;
import com.wyl.xue.util.result.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
@ResponseBody
public class UserController {

    private final SystemUsersService systemUsersService;

    @ApiOperation(value = "用户登录接口", notes = "返回的token需要填写到相关请求头中")
    @PostMapping(value = "/login")
    public WebResult<String> login(String username, String password) {
        return WebResponse.WebResponse.ok("");
    }

    @ApiOperation(value = "用户新增接口", notes = "新建一个用户")
    @PostMapping(value = "/user")
    public WebResult<Boolean> addUser(@RequestBody SystemUsers userInfo) {
        return WebResponse.WebResponse.ok(systemUsersService.save(userInfo));
    }

    @ApiOperation(value = "用户更新接口", notes = "更新用户的信息")
    @PutMapping(value = "/user")
    public WebResult<Boolean> changeUser(@RequestBody SystemUsers userInfo) {
        return WebResponse.WebResponse.ok(systemUsersService.updateById(userInfo));
    }

    @ApiOperation(value = "用户删除接口", notes = "根据用户ID删除用户")
    @DeleteMapping(value = "/user/{id}")
    public WebResult<Boolean> deleteUser(@PathVariable String id) {
        return WebResponse.WebResponse.ok(systemUsersService.removeById(id));
    }

    @ApiOperation(value = "查询用户信息", notes = "根据用户ID查询用户信息")
    @GetMapping(value = "/user/{id}")
    public WebResult<SystemUsers> getUserInfo(@PathVariable String id) {
        return WebResponse.WebResponse.ok(systemUsersService.getById(id));
    }

    @ApiOperation(value = "根据部门ID获取用户列表", notes = "根据部门ID获取用户列表")
    @GetMapping(value = "/user/{departmentId}/{page}/{size}")
    public WebResult<IPage<SystemUsers>> getUserInfoListByDepartment(@PathVariable String departmentId, @PathVariable Integer page, @PathVariable Integer size) {
        return WebResponse.WebResponse.ok(systemUsersService.getSystemUsersByDepartmentId(departmentId, page, size));
    }

    @ApiOperation(value = "重置用户密码")
    @PutMapping(value = "/user/reset/{id}")
    public WebResult<String> resetPassword(@PathVariable String id) {
        return WebResponse.WebResponse.ok(systemUsersService.resetPasswordById(id));
    }

    @ApiOperation(value = "设置用户角色")
    @PostMapping(value = "/user/roles/{id}")
    public WebResult<Boolean> setUserRoles(@PathVariable String id, @RequestBody List<String> roleIds) {
        return WebResponse.WebResponse.ok(systemUsersService.setUserRoles(id, roleIds));
    }

}
