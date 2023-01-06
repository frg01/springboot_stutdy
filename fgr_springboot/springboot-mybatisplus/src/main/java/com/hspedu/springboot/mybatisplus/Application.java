package com.hspedu.springboot.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * @MapperScan 可以指定要扫描的多个mapper包
 */
@MapperScan(basePackages = {"com.hspedu.springboot.mybatisplus.mapper"})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
