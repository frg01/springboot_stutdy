package com.hspedu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
//@ServletComponentScan(basePackages = "com.hspedu.springboot")//扫描包下的原生Servlet
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc
                = SpringApplication.run(Application.class, args);
//        ioc.stop();
        System.out.println("hello");
    }
}
