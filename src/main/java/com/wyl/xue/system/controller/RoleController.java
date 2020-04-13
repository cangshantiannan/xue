/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyl.xue.system.mybatis.entity.SystemRoles;
import com.wyl.xue.system.mybatis.service.SystemRolesService;
import com.wyl.xue.util.result.WebResponse;
import com.wyl.xue.util.result.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: RoleController
 * @Function: TODO
 * @Date: 2019/12/23 22:12
 * @author wyl
 * @version V1.0
 */
@Controller
@RequestMapping("/v1")
@Api(tags = {"角色信息接口"})
@AllArgsConstructor
@ResponseBody
public class RoleController {

    final SystemRolesService systemRolesService;

    @ApiOperation(value = "添加角色信息", notes = "新建一个角色")
    @PostMapping(value = "/role")
    public WebResult<Boolean> addRole(@RequestBody SystemRoles systemRoles) {
        return WebResponse.WebResponse.ok(systemRolesService.save(systemRoles));
    }

    @PutMapping(value = "/role/{id}")
    @ApiOperation(value = "修改角色信息")
    public WebResult<Boolean> changeRole(@RequestBody SystemRoles systemRoles) {
        return WebResponse.WebResponse.ok(systemRolesService.updateById(systemRoles));
    }

    @DeleteMapping(value = "/role/{id}")
    @ApiOperation(value = "通过ID删除一个角色")
    public WebResult<Boolean> deleteRole(@PathVariable Integer id) {
        return WebResponse.WebResponse.ok(systemRolesService.removeById(id));
    }

    @GetMapping(value = "/role/{page}/{size}")
    @ApiOperation(value = "通过用户id 获取该用户下的所有角色")
    public WebResult<IPage<SystemRoles>> getRolesInfo(@PathVariable Integer page, @PathVariable Integer size) {
        return WebResponse.WebResponse.ok(systemRolesService.getRolesInfo(page, size));
    }

    @GetMapping(value = "/role/user/{userid}")
    @ApiOperation(value = "通过用户id 获取该用户下的所有角色")
    public WebResult<List<SystemRoles>> getRolesInfoByUserId(@PathVariable String userId) {
        return WebResponse.WebResponse.ok(systemRolesService.getRolesByUserId(userId));
    }
}
