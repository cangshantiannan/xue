/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.system.manage.controller;

import com.wyl.xue.util.WebResult;
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
public class RoleController {

    @PostMapping(value = "/role")
    @ResponseBody
    public WebResult addUser(@RequestBody String tmp) {
        return WebResult.ok(1);
    }

    @PutMapping(value = "/role/{id}")
    @ResponseBody
    public WebResult changeUser(@RequestBody String tmp) {
        return WebResult.ok(1);
    }

    @DeleteMapping(value = "/role/{id}")
    @ResponseBody
    public WebResult deleteUser(@PathVariable Integer id) {
        return WebResult.ok(1);
    }
}
