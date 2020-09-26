package com.wyl.xue.admin;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wyl
 */
@SpringBootApplication
/**
 * ComponentScan 和 SpringBootApplication 共存是会导致SpringBootApplication 扫包路径时效，所以需要手动增加路径
 */
@ComponentScan({"com.wyl.xue.admin.*", "com.wyl.xue.core.*"})
@MapperScan({"com.wyl.xue.admin.system.mybatis.mapper"})
public class XueBackgroundApplication {

    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(XueBackgroundApplication.class);
        sa.addListeners(new ApplicationPidFileWriter());
        sa.run(args);
    }

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
