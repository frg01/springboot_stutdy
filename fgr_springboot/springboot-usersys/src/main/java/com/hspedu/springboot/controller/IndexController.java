package com.hspedu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Controller
public class IndexController {

    @GetMapping({"/","/login"})
    public String login(){
        //解读引入了starter-thymeleaf 会使用视图解析器 到thymeleaf下的模板文件
        return "adminLogin";
    }
}
