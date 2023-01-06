package com.hspedu.springboot.config;

import com.hspedu.springboot.bean.Car;
import com.hspedu.springboot.bean.Monster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
//proxyBeanMethods = false  表示WebConfig是一个配置类 并启用了lite模式（多例）
@Configuration(proxyBeanMethods = false)
public class WebConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Car>() {
                    @Override
                    public Car convert(String s) {
                        String[] split = s.split(",");
                        Car car = new Car();
                        car.setName(split[0]);
                        car.setPrice(Double.parseDouble(split[1]));
                        return car;
                    }
                });
            }
        };
    }
    //注入WebMvcConfigurer
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addFormatters(FormatterRegistry registry) {
//                /**
//                 * addFormatters方法中添加自定义转换器 能将String转换成Car
//                 * 自定义转换器会注册到converters 容器中
//                 * converters 底层结构是ConcurrentHashMap 内置124转换器
//                 */
//                //第一个自定义转换器
//                registry.addConverter(new Converter<String, Car>() {
//
//
//                    @Override
//                    public Car convert(String s) {
//                        if (!ObjectUtils.isEmpty(s)){
//                            String[] split = s.split(",");
//                            Car car = new Car();
//                            car.setName(split[0]);
//                            car.setPrice(Double.parseDouble(split[1]));
//                            return car;
//                        }
//                        return null;
//                    }
//                });
//
//                //第二个自定义转换器
//                registry.addConverter(new Converter<String, Monster>() {
//                    @Override
//                    public Monster convert(String s) {
//                        return null;
//                    }
//                });
//            }
//        };
//    }
}
