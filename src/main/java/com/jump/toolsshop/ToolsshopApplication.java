package com.jump.toolsshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jump.toolsshop.mapper")
public class ToolsshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolsshopApplication.class, args);
    }

}
