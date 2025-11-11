package com.zuning.eunomiapicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.zuning.eunomiapicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class EunomiaPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EunomiaPictureBackendApplication.class, args);
    }

}
