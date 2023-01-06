package com.hspedu.fgrspringboot;

import com.hspedu.fgrspringboot.config.FgrConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 容器的初始化器
 */

/**
 * 1.创建spring容器
 * 2.加载或关联spring容器的配置  按照注解的方式
 * 3.完成spring容器配置的bean的创建，依赖注入
 * 4.创建前端控制器DispatcherServlet,并让其持有spring容器
 * 5.当dispatcherServlet 持有容器，就可以进行分发映射（springmvc底层）
 * 6.onStartup  tomcat调用  并把ServletContext对象传入
 */
public class FgrWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("start up ...");
        //加载spring web application configuration
        AnnotationConfigWebApplicationContext ac =
                new AnnotationConfigWebApplicationContext();
        //再ac中注册FgrConfig.class 配置类
        ac.register(FgrConfig.class);
        ac.refresh();//完成bean的创建和配置

        //创建注册非常重要的前端控制器 DispatcherServlet
        //DispatcherServlet要持有ac容器 这样就可以进行映射分发
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
        //返回ServletRegistration.Dynamic对象
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", dispatcherServlet);
        //tomcat启动时  ，加载dispatcherServlet
        registration.setLoadOnStartup(1);
        //拦截请求  并进行分发处理 /和/*
        registration.addMapping("/");



    }
}
