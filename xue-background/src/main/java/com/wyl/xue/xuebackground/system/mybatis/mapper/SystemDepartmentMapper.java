package com.wyl.xue.xuebackground.system.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyl.xue.xuebackground.system.mybatis.entity.SystemDepartment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: SystemDepartmentMapper
 * @Function:  部门信息Mapper
 * @Date:      2019/12/18 0:39
 * @author     wangyl
 * @version    V1.0
 */ 
@Mapper
public interface SystemDepartmentMapper extends BaseMapper<SystemDepartment> {
}