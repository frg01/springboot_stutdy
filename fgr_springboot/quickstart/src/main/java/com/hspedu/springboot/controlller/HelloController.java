package com.hspedu.springboot.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Controller
public class HelloController {
//    返回Hello ,SPRING BOOT
   @RequestMapping("hello")
   @ResponseBody
   public String hello(){
       return "hello,springboot";
   }
}
