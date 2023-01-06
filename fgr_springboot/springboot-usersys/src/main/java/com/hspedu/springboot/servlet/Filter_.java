package com.hspedu.springboot.servlet;

import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 开发Filter 并注入
 * @WebFilter表示是一个过滤器  并注入容器
 * urlPatterns  此之地那个目录下的资源请求会经过过滤器啊
 * 放行后经过拦截器 看其是否拦截
 */
//@WebFilter(urlPatterns = {"/css/*","/images/*"})
@Slf4j
public class Filter_ implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("--Filter_  init--");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("--Filter_  doFilter--");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        log.info("过滤器处理的uri={}",httpServletRequest.getRequestURI());
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("--Filter_  destroy--");
    }
}
