package com.hspedu.fgrspringboot.config;

import com.hspedu.fgrspringboot.bean.Monster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 在配置类指定要扫描的包@ComponentScan("com.hspedu.fgrspringboot")
 */
@Configuration
@ComponentScan("com.hspedu.fgrspringboot")
public class FgrConfig {

    //注入Bean  monster 对象到Spring容器
    @Bean
    public Monster monster(){
        return new Monster();
    }
}
