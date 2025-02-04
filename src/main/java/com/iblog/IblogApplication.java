package com.iblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.iblog.mapper")
@SpringBootApplication
public class IblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(IblogApplication.class, args);
    }

}
