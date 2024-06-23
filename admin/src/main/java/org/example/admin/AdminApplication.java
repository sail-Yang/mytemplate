package org.example.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/6/23 10:53
 */
@SpringBootApplication
@MapperScan("org.example.admin.dao.mapper")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
