package com.hspedu.springboot.config;

import com.hspedu.springboot.servlet.Filter_;
import com.hspedu.springboot.servlet.Listener_;
import com.hspedu.springboot.servlet.Servlet_;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.Servlet;
import javax.servlet.ServletRegistration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 配置类
 */
@Configuration(proxyBeanMethods = true)
public class RegisterConfig {

    @Bean
    public ServletRegistrationBean servlet_() {
        //创建原生的Servlet对象
        Servlet_ servlet_ = new Servlet_();
        //将servlet_对象关联到ServletRegistrationBean 对象  并指定urlPattern
        return new ServletRegistrationBean(servlet_, "/servlet01", "/servlet02");
    }

    //注入filter
    @Bean
    public FilterRegistrationBean filter_(){
        Filter_ filter_ = new Filter_();

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter_);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/css/*","/images/*"));
        return filterRegistrationBean;
    }

    //注入Listener
    @Bean
    public ServletListenerRegistrationBean listener_(){
        //创建原生的listener
        Listener_ listener_ = new Listener_();
        return new ServletListenerRegistrationBean(listener_);
    }
}
