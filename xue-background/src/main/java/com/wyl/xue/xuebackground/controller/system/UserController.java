package com.wyl.xue.xuebackground.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyl.xue.core.util.result.WebResponse;
import com.wyl.xue.core.util.result.WebResult;
import com.wyl.xue.xuebackground.security.user.SecurityUserInfo;
import com.wyl.xue.xuebackground.system.mybatis.entity.SystemUsers;
import com.wyl.xue.xuebackground.system.mybatis.service.SystemUsersService;
import com.wyl.xue.xuebackground.system.vo.UserLoginInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


/**
 * @ClassName: UserController
 * @Function: 用户接口
 * @Date: 2019/12/22 17:26
 * @author wyl
 * @version V1.0
 */
@RequestMapping("/v1")
@Api(tags = {"用户信息接口"})
@AllArgsConstructor
@RestController
@CrossOrigin
public class UserController {

    private final SystemUsersService systemUsersService;

    @ApiOperation(value = "用户登录接口", notes = "返回的token需要填写到相关请求头中")
    @PostMapping(value = "/login")
    public WebResult<String> login(@RequestBody UserLoginInfo userLoginInfo) {
        return WebResponse.WebResponse.ok(systemUsersService.login(userLoginInfo.getUsername(), userLoginInfo.getPassword()));
    }

    @ApiOperation(value = "用户新增接口", notes = "新建一个用户")
    @PostMapping(value = "/user")
    @PreAuthorize("hasAuthority('sys:user:add')")
    public WebResult<Boolean> addUser(@RequestBody SystemUsers userInfo) {
        return WebResponse.WebResponse.ok(systemUsersService.save(userInfo));
    }

    @ApiOperation(value = "用户更新接口", notes = "更新用户的信息")
    @PutMapping(value = "/user")
    @PreAuthorize("hasAuthority('sys:user:update')")
    public WebResult<Boolean> changeUser(@RequestBody SystemUsers userInfo) {
        return WebResponse.WebResponse.ok(systemUsersService.updateById(userInfo));
    }

    @ApiOperation(value = "用户删除接口", notes = "根据用户ID删除用户")
    @DeleteMapping(value = "/user/{id}")
    @PreAuthorize("hasAuthority('sys:user:del')")
    public WebResult<Boolean> deleteUser(@PathVariable String id) {
        return WebResponse.WebResponse.ok(systemUsersService.removeById(id));
    }

    @ApiOperation(value = "查询用户信息", notes = "根据用户ID查询用户信息")
    @GetMapping(value = "/user")
    public WebResult<SystemUsers> getUserInfo() {
        SecurityUserInfo systemUsers = (SecurityUserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return WebResponse.WebResponse.ok(systemUsersService.getById(systemUsers.getUserId()));
    }

    @ApiOperation(value = "根据部门ID获取用户列表", notes = "根据部门ID获取用户列表")
    @GetMapping(value = "/user/{departmentId}/{page}/{size}")
    public WebResult<IPage<SystemUsers>> getUserInfoListByDepartment(@PathVariable String departmentId, @PathVariable Integer page, @PathVariable Integer size) {
        return WebResponse.WebResponse.ok(systemUsersService.getSystemUsersByDepartmentId(departmentId, page, size));
    }

    @ApiOperation(value = "重置用户密码")
    @PutMapping(value = "/user/reset/{id}")
    @PreAuthorize("hasAuthority('sys:user:reset')")
    public WebResult<String> resetPassword(@PathVariable String id) {
        return WebResponse.WebResponse.ok(systemUsersService.resetPasswordById(id));
    }

    @ApiOperation(value = "设置用户角色")
    @PostMapping(value = "/user/roles/{id}")
    @PreAuthorize("hasAuthority('sys:user:setrole')")
    public WebResult<Boolean> setUserRoles(@PathVariable String id, @RequestBody List<String> roleIds) {
        return WebResponse.WebResponse.ok(systemUsersService.setUserRoles(id, roleIds));
    }

    @ApiOperation(value = "获取用户可以访问的路由")
    @GetMapping(value = "/user/router")
    public WebResult<Set<String>> getUserRouter() {
        SecurityUserInfo systemUsers = (SecurityUserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return WebResponse.WebResponse.ok(systemUsersService.getUserRouterByUserId(systemUsers.getUserId()));
    }


}
