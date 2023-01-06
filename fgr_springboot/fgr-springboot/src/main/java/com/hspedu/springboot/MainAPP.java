package com.hspedu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@SpringBootApplication
public class MainAPP {
    public static void main(String[] args) {
        //启动springboot应用程序/项目
        //执行run方法时,怎么启动内置的tomcat
        //再分析run方法的基础上,自己尝试实现
        ConfigurableApplicationContext ioc =
                SpringApplication.run(MainAPP.class, args);

        /**
         * 开始degug springApplication.run()
         *1.SpringApplication的run方法
         * 2.还是另一个run方法
         * 3.再一个run方法中创建容器context = this.createApplicationContext();
         * this.refreshContext(context); 刷新上下文，初始化设置/启动tomcat
         * 4.createApplicationContext()方法  会根据this.webApplicationType创建对应的容器  web容器可以处理servlet
         * 5.ApplicationContextFactory.java 进入以下分支
         * case SERVLET:
         *         return new AnnotationConfigServletWebServerApplicationContext();
         *6.refreshContext方法  this.refresh(context)真正执行相关任务
         * 7.public final void refresh() 方法  super.refresh();用法
         *8.AbstractApplicationContext.java 的refresh()方法 中
         * this.onRefresh();父类完成了通用的工作后 再重新动态绑定回子类方法
         *9. 子类中onRefresh()方法this.createWebServer(); 去创建指定的webserver
         * 10.此执行this.webServer = factory.getWebServer 创建tomcatWebserver
         * 11.TomcatServletWebServerFactory.java中getWebServer方法
         * Tomcat tomcat = new Tomcat()做了一系列设置
         * return this.getTomcatWebServer(tomcat)严重分析该方法
         * 12.getTomcatWebServer方法做校验
         *13. TomcatWebServer中this.initialize();方法
         * 14.initialize()中this.tomcat.start()方法 启动tomcat
         */
        System.out.println("hello ioc");
    }
}
