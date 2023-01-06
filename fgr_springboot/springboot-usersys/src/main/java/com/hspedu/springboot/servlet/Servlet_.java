package com.hspedu.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 通过继承HttpServlet来开发原生Servlet
 * WebServlet 标识将SServlet_对象注入到容器
 * urlPatterns = {"/servlet01","/servlet02"} 对servlet配置了urlPatterns
 * 注入的原生的servlet不会被拦截器拦截
 * 对于开发的原生servlet  需要使用@ServletComponentScan指定要扫描的servlet所在包，才会注入spring容器
 */
//@WebServlet(urlPatterns = {"/servlet01","/servlet02"})
public class Servlet_ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("hello,Servlet_!");
    }

}
