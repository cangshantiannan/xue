package com.wyl.xue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wyl.xue.mybatis.mapper")
public class XueApplication {

	public static void main(String[] args) {
		SpringApplication.run(XueApplication.class, args);
	}

}
