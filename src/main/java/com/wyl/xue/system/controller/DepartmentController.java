/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.system.controller;

import com.wyl.xue.system.mybatis.entity.SystemDepartment;
import com.wyl.xue.system.mybatis.entity.SystemUsers;
import com.wyl.xue.system.mybatis.service.SystemDepartmentService;
import com.wyl.xue.util.result.ResultCode;
import com.wyl.xue.util.result.WebResponse;
import com.wyl.xue.util.result.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
public class DepartmentController {


    final private SystemDepartmentService systemDepartmentService;

    @PostMapping(value = "/department")
    @ResponseBody
    @ApiOperation(value = "添加部门接口", notes = "添加部门接口")
    public WebResult addDepartment(@RequestBody SystemDepartment systemDepartment) {
        if (systemDepartment.insert()) {
            return WebResponse.WebResponse.ok();
        }
        return WebResponse.WebResponse.error(ResultCode.DATAINSERTERROR);
    }

    @PutMapping(value = "/department/{id}")
    @ResponseBody
    @ApiOperation(value = "修改部门信息接口", notes = "修改部门信息接口")
    public WebResult changeDepartment(@RequestBody SystemDepartment systemDepartment) {
        if (systemDepartment.updateById()) {
            return WebResponse.WebResponse.ok();
        }
        return WebResponse.WebResponse.error(ResultCode.DATAINSERTERROR);
    }

    @DeleteMapping(value = "/department/{id}")
    @ResponseBody
    @ApiOperation(value = "删除部门信息", notes = "根据部门ID删除指定部门")
    public WebResult deleteDepartment(@PathVariable String id) {
        SystemDepartment systemDepartment = SystemDepartment.builder().departmentId(id).build();
        if (systemDepartment.deleteById()) {
            return WebResponse.WebResponse.ok();
        }
        return WebResponse.WebResponse.error(ResultCode.DATAINSERTERROR);
    }

    @ApiOperation(value = "获取部门树", notes = "获取部门树")
    @GetMapping(value = "/department")
    @ResponseBody
    public WebResult getUserInfo() {
        return WebResponse.WebResponse.ok(systemDepartmentService.getDepartmentTree());
    }

}
