package com.hspedu.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * GlobalExceptionHandler 被注入到spring容器
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //编写方法，处理指定异常
    //Exception e 异常发生后 传递的异常对象
    //Model model 将异常信息放入model 传递给显示页面
    //如何让获取到异常发生的方法
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class,AccessException.class})
    public String handleAritException(Exception e, Model model, HandlerMethod handlerMethod){
        log.info("异常信息--",e.getMessage());
        //放入model 再错误页面取出
        model.addAttribute("msg",e.getMessage());
        //异常发生的方法
        log.info("异常发生的方法={}",handlerMethod.getMethod());
        return "/error/global";
    }
}
