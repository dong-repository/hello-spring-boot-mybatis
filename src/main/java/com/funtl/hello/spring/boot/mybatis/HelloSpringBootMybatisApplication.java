package com.funtl.hello.spring.boot.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.funtl.hello.spring.boot.mybatis.dao")
@SpringBootApplication
public class HelloSpringBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootMybatisApplication.class, args);
    }

}
