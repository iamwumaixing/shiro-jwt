package com.wu.jwt_shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Qwu
 */
@SpringBootApplication
@MapperScan("com.wu.jwt_shiro.mapper")
public class JwtShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtShiroApplication.class, args);
    }

}
