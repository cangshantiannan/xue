package com.wyl.xue.modle.test.mybatis.service.Impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.modle.test.mybatis.entity.Test;
import com.wyl.xue.modle.test.mybatis.mapper.TestMapper;
import com.wyl.xue.modle.test.mybatis.service.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @ClassName: SystemDepartmentServiceImpl
 * @Function: 部门
 * @Date: 2019/12/18 22:11
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
@AllArgsConstructor
@DS("slave_1")
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {}
