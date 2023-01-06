package com.hspedu.springboot.config;

import com.hspedu.springboot.bean.Monster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 第二个人
 */
@Configuration
public class BeanConfig2 {

    @Bean
    public Monster monster02(){
        return new Monster(200,"蚂蚁精",500,"牛角");
    }
}
