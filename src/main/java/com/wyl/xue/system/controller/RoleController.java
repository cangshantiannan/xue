/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.system.manage.controller;

import com.wyl.xue.system.mybatis.entity.SystemRoles;
import com.wyl.xue.util.result.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
public class RoleController {

    @ApiOperation(value = "添加角色信息", notes = "新建一个角色")
    @PostMapping(value = "/role")
    @ResponseBody
    public WebResult addRole(@RequestBody SystemRoles systemRoles) {
        return null;
    }

    @PutMapping(value = "/role/{id}")
    @ResponseBody
    public WebResult changeRole(@RequestBody String tmp) {
        return null;
    }

    @DeleteMapping(value = "/role/{id}")
    @ResponseBody
    public WebResult deleteRole(@PathVariable Integer id) {
        return null;
    }
}
