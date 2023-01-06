package com.hspedu.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Configuration
//导入beans.xml文件  就可以beans.xml中配置的beans
@ImportResource(locations = {"classpath:beans.xml","classpath:beans02.xml"})
public class BeanConfig3 {
}
