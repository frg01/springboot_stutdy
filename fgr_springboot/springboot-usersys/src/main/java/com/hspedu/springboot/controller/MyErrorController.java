package com.hspedu.springboot.controller;

import com.hspedu.springboot.exception.AccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Controller
public class MyErrorController {

    //模拟服务器内部错误
    @GetMapping("/err")
    public String err(){
        int i = 10/0;
        return "manage";
    }

    //post方式请求err2 用get请求会出现客户端错误405
    @PostMapping("/err2")
    public String err2(){
        return "manage";
    }

    //模拟AccessException
    @GetMapping("err3")
    public String err3(String name){
        if (!"tom".equals(name)){//构造一个异常
            throw new AccessException("自定义异常AccessException");
        }
        return "message";//视图地址
    }
}
