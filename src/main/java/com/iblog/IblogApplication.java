package com.iblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.iblog.mapper")
public class IblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(IblogApplication.class, args);
    }

}
