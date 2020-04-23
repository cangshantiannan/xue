/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.xuebackground.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyl.xue.core.util.result.WebResponse;
import com.wyl.xue.core.util.result.WebResult;
import com.wyl.xue.xuebackground.system.mybatis.entity.SystemRoles;
import com.wyl.xue.xuebackground.system.mybatis.service.SystemRolesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: RoleController
 * @Function: 角色信息接口
 * @Date: 2019/12/23 22:12
 * @author wyl
 * @version V1.0
 */
@RequestMapping("/v1")
@Api(tags = {"角色信息接口"})
@AllArgsConstructor
@RestController
public class RoleController {

    final SystemRolesService systemRolesService;

    @ApiOperation(value = "添加角色信息", notes = "新建一个角色")
    @PostMapping(value = "/role")
    @PreAuthorize("hasAuthority('sys:role:add')")
    public WebResult<Boolean> addRole(@RequestBody SystemRoles systemRoles) {
        return WebResponse.WebResponse.ok(systemRolesService.save(systemRoles));
    }

    @PutMapping(value = "/role/{id}")
    @ApiOperation(value = "修改角色信息")
    @PreAuthorize("hasAuthority('sys:role:change')")
    public WebResult<Boolean> changeRole(@RequestBody SystemRoles systemRoles) {
        return WebResponse.WebResponse.ok(systemRolesService.updateById(systemRoles));
    }

    @DeleteMapping(value = "/role/{id}")
    @ApiOperation(value = "通过ID删除一个角色")
    @PreAuthorize("hasAuthority('sys:role:del')")
    public WebResult<Boolean> deleteRole(@PathVariable Integer id) {
        return WebResponse.WebResponse.ok(systemRolesService.removeById(id));
    }

    @GetMapping(value = "/role/{page}/{size}")
    @ApiOperation(value = "获取所有角色信息")
    public WebResult<IPage<SystemRoles>> getRolesInfo(@PathVariable Integer page, @PathVariable Integer size) {
        return WebResponse.WebResponse.ok(systemRolesService.getRolesInfo(page, size));
    }

    @GetMapping(value = "/role/user/{userid}")
    @ApiOperation(value = "通过用户id 获取该用户下的所有角色")
    @PreAuthorize("hasAuthority('sys:role:getuser')")
    public WebResult<List<SystemRoles>> getRolesInfoByUserId(@PathVariable String userId) {
        return WebResponse.WebResponse.ok(systemRolesService.getRolesByUserId(userId));
    }

    @PostMapping(value = "/role/menus/{id}")
    @ApiOperation(value = "设置角色的菜单信息")
    @PreAuthorize("hasAuthority('sys:role:setmenu')")
    public WebResult<Boolean> setRoleMenus(@PathVariable String id, @RequestBody List<String> menuIds) {
        return WebResponse.WebResponse.ok(systemRolesService.setRoleMenus(id, menuIds));
    }
}
