package com.hspedu.springboot.config;

import com.hspedu.springboot.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * @Configuration 标识一个配置类 再springboot扫描的包下,会被注入到容器中
 * 充当spring配置文件角色  可以@Bean注入其他组件
 */
@Configuration
public class Config {


    @Bean
    public Dog dog(){
        return new Dog();
    }
}
