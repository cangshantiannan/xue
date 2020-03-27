package com.wyl.xue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * @author wyl
 */
@SpringBootApplication
@MapperScan("com.wyl.xue.system.mybatis.mapper")
public class XueApplication {
    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(XueApplication.class);
        sa.addListeners(new ApplicationPidFileWriter());
        sa.run(args);
    }

}
