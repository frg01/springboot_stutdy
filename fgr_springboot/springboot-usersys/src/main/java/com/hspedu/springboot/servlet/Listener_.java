package com.hspedu.springboot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Slf4j
//@WebListener()
public class Listener_ implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //加入项目初始化相关业务代码
        log.info("Listener_ contextInitialized 项目初始化ok");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //响应代码
        log.info("Listener_ contextDestroyed 项目销毁ok");

    }
}
