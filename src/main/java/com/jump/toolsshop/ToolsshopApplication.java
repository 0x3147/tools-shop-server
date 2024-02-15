package com.jump.toolsshop;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jump.toolsshop.mapper")
public class ToolsshopApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ToolsshopApplication.class);

    public static void main(String[] args) {

        var app = SpringApplication.run(ToolsshopApplication.class, args);

        var port = app.getEnvironment().getProperty("server.port");

        LOG.info("服务已启动!");

        LOG.info("服务地址: \thttp://127.0.0.1:{}", port);
    }

}
