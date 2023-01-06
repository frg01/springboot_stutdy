package com.hspedu.fgrspringboot;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class FgrSpringApplication {

    //创建tomcat对象  并关联spring容器并启动
    public static void run(){
        try {
            //创建tomcat对象
            Tomcat tomcat = new Tomcat();
            //让tomcat可以将请求转发到spring web容器 进行关联
            ///fgrboot是我们的项目的application context 是配置tomcat时，指定的application context
            //D:\fgr_springboot\fgr-springboot  指定项目的目录
            tomcat.addWebapp("/fgrboot","D:\\fgr_springboot\\fgr-springboot");
            //设置9090端口
            tomcat.setPort(9090);
            //启动
            tomcat.start();
            //等待请求接入
            System.out.println("=====9090====等待请去===");
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
