//package com.hspedu.springboot.filter;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import java.io.IOException;
//
///**
// * @author: guorui fu
// * @versiion: 1.0
// */
//@Component
//public class FgrFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("FgrFilter的init。。。");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("FgrFilter 被调用。。。");
//        filterChain.doFilter(servletRequest,servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("FgrFilter的destroy()...");
//    }
//}
