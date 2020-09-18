/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.admin.controller.system;

import com.wyl.xue.admin.system.mybatis.service.SystemMenuService;
import com.wyl.xue.admin.system.vo.MenuTree;
import com.wyl.xue.core.util.result.WebResponse;
import com.wyl.xue.core.util.result.WebResult;
import com.wyl.xue.admin.system.mybatis.entity.SystemMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: MenuController
 * @Function: 菜单接口
 * @Date: 2019/12/23 22:13
 * @author wyl
 * @version V1.0
 */
@RestController
@RequestMapping("/v1")
@Api(tags = {"菜单信息接口"})
@AllArgsConstructor
public class MenuController {

    private final SystemMenuService systemMenuService;

    @PostMapping(value = "/menu")
    @ApiOperation(value = "新增菜单信息", notes = "根据菜单信息新增菜单")
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public WebResult<Boolean> addMenu(@RequestBody SystemMenu systemMenu) {
        return WebResponse.WebResponse.ok(systemMenuService.save(systemMenu));
    }

    @PutMapping(value = "/menu")
    @ApiOperation(value = "更新菜单信息", notes = "根据菜单信息更新菜单")
    @PreAuthorize("hasAuthority('sys:menu:update')")
    public WebResult<Boolean> changeMenu(@RequestBody SystemMenu systemMenu) {
        return WebResponse.WebResponse.ok(systemMenuService.updateById(systemMenu));
    }


    @GetMapping(value = "/menu/tree")
    @ApiOperation(value = "获取菜单树 不包含按钮")
    public WebResult<List<MenuTree>> menuTree() {
        return WebResponse.WebResponse.ok(systemMenuService.getMenuTree());
    }

    @DeleteMapping(value = "/menu/{id}")
    @ApiOperation(value = "删除菜单信息", notes = "根据菜单id删除指定菜单")
    @PreAuthorize("hasAuthority('sys:menu:del')")
    public WebResult<Boolean> deleteMenu(@PathVariable String id) {
        return WebResponse.WebResponse.ok(systemMenuService.removeById(id));
    }

    @GetMapping(value = "/menus/{id}")
    @ApiOperation(value = "获取指定菜单下的所有按钮")
    public WebResult<List<SystemMenu>> getMenusById(@PathVariable String id) {
        return WebResponse.WebResponse.ok(systemMenuService.getMenusById(id));
    }
}
