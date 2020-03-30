/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.mybatis.entity.SystemDepartment;
import com.wyl.xue.mybatis.mapper.SystemDepartmentMapper;
import com.wyl.xue.mybatis.service.SystemDepartmentService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SystemDepartmentServiceImpl
 * @Function: TODO
 * @Date: 2019/12/18 22:11
 * @author wyl
 * @version V1.0
 */
@Service
public class SystemDepartmentServiceImpl extends ServiceImpl<SystemDepartmentMapper, SystemDepartment> implements SystemDepartmentService {}
