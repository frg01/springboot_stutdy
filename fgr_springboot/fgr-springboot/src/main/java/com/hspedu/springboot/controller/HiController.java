package com.hspedu.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * HiController是一个控制器  再扫描包下 会被注入到spring容器
 */
@RestController
public class HiController {

    @RequestMapping("/hi")
    public String hi(){
        return "hi hsp HiController";
    }
}
