/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.system.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wyl.xue.mybatis.entity.SystemMenu;
import com.wyl.xue.mybatis.service.SystemMenuService;
import com.wyl.xue.util.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@Api(value="swagger测试", description="TestController")
public class MenuController {
    @Autowired
    private SystemMenuService systemMenuService;

    @PostMapping(value = "/menu")
    @ResponseBody
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    public WebResult addMenu(@RequestBody SystemMenu systemMenu) {
        if (systemMenu.insert()) {
            return WebResult.ok(systemMenu);
        }
        return WebResult.error("创建失败");
    }

    @PutMapping(value = "/menu")
    @ResponseBody
    public WebResult changeMenu(@RequestBody SystemMenu systemMenu) {
        if (systemMenu.updateById()) {
            return WebResult.ok();
        }
        return WebResult.error("修改失败");
    }

    @DeleteMapping(value = "/menu/{id}")
    @ResponseBody
    public WebResult deleteMenu(@PathVariable Integer id) {
        if (SystemMenu.builder().menuId(id).build().deleteById()) {
            return WebResult.ok();
        }
        return WebResult.error("删除失败");
    }


    @GetMapping(value = "/menu")
    @ResponseBody
    public WebResult getMenu() {
        List<SystemMenu> systemMenuList = systemMenuService.getBaseMapper().selectList(new QueryWrapper<>(null));
        return WebResult.ok(systemMenuList);
    }
}
