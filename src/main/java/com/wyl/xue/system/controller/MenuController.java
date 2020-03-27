/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wyl.xue.system.mybatis.entity.SystemMenu;
import com.wyl.xue.system.mybatis.entity.SystemUsers;
import com.wyl.xue.system.mybatis.service.SystemMenuService;
import com.wyl.xue.util.result.ResultCode;
import com.wyl.xue.util.result.WebResponse;
import com.wyl.xue.util.result.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: MenuController
 * @Function: TODO
 * @Date: 2019/12/23 22:13
 * @author wyl
 * @version V1.0
 */
@Controller
@RequestMapping("/v1")
@Slf4j
@Api(tags = {"菜单信息接口"})
@AllArgsConstructor
public class MenuController {

    private final SystemMenuService systemMenuService;

    @PostMapping(value = "/menu")
    @ResponseBody
    @ApiOperation(value = "新增菜单信息", notes = "根据菜单信息新增菜单")
    public WebResult addMenu(@RequestBody SystemMenu systemMenu) {
        if (systemMenu.insert()) {
            return WebResponse.WebResponse.ok();
        }
        return WebResponse.WebResponse.error(ResultCode.DATAINSERTERROR);
    }

    @PutMapping(value = "/menu")
    @ResponseBody
    @ApiOperation(value = "更新菜单信息", notes = "根据菜单信息更新菜单")
    public WebResult changeMenu(@RequestBody SystemMenu systemMenu) {
        if (systemMenu.updateById()) {
            return WebResponse.WebResponse.ok();
        }
        return WebResponse.WebResponse.error(ResultCode.DATAINSERTERROR);
    }

    @DeleteMapping(value = "/menu/{id}")
    @ResponseBody
    @ApiOperation(value = "删除菜单信息", notes = "根据菜单id删除指定菜单")
    public WebResult deleteMenu(@PathVariable Integer id) {
        SystemMenu users = SystemMenu.builder().menuId(id).build();
        if (users.deleteById()) {
            return WebResponse.WebResponse.ok();
        }
        return WebResponse.WebResponse.error(ResultCode.DATAINSERTERROR);
    }


    @GetMapping(value = "/menu")
    @ResponseBody
    @ApiOperation(value = "以树形结构获取菜单信息", notes = "一次以树形结构获取菜单信息")
    public WebResult getMenu() {
        return WebResponse.WebResponse.ok(systemMenuService.count());
    }
}