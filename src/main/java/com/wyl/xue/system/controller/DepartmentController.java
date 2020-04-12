/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.system.controller;

import com.wyl.xue.system.mybatis.entity.SystemDepartment;
import com.wyl.xue.system.mybatis.service.SystemDepartmentService;
import com.wyl.xue.system.vo.DepartmentTree;
import com.wyl.xue.util.result.WebResponse;
import com.wyl.xue.util.result.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: DepartmentController
 * @Function: TODO
 * @Date: 2019/12/23 22:12
 * @author wyl
 * @version V1.0
 */
@Controller
@RequestMapping("/v1")
@Api(tags = {"部门信息接口"})
@AllArgsConstructor
@ResponseBody
public class DepartmentController {

    final private SystemDepartmentService systemDepartmentService;

    @PostMapping(value = "/department")
    @ApiOperation(value = "添加部门接口", notes = "添加部门接口")
    public WebResult<Boolean> addDepartment(@RequestBody SystemDepartment systemDepartment) {
        return WebResponse.WebResponse.ok(systemDepartmentService.save(systemDepartment));
    }

    @PutMapping(value = "/department/{id}")
    @ApiOperation(value = "修改部门信息接口", notes = "修改部门信息接口")
    public WebResult<Boolean> changeDepartment(@RequestBody SystemDepartment systemDepartment) {
        return WebResponse.WebResponse.ok(systemDepartmentService.updateById(systemDepartment));
    }

    @DeleteMapping(value = "/department/{id}")
    @ApiOperation(value = "删除部门信息", notes = "根据部门ID删除指定部门")
    public WebResult<Boolean> deleteDepartment(@PathVariable String id) {
        return WebResponse.WebResponse.ok(systemDepartmentService.removeById(id));
    }

    @ApiOperation(value = "获取部门树", notes = "获取部门树")
    @GetMapping(value = "/department")
    public WebResult<List<DepartmentTree>> getUserInfo() {
        return WebResponse.WebResponse.ok(systemDepartmentService.getDepartmentTree());
    }

    @ApiOperation(value = "获取指定部门下的一级子目录")
    @GetMapping
    public WebResult<List<SystemDepartment>> getSubdirectoryById(@PathVariable String id) {
        return null;
    }

}
