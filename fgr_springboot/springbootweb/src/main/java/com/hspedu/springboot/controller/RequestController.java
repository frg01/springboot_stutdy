package com.hspedu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Controller
public class RequestController {

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        request.setAttribute("user", "老付");//向所有request域中添加数据
        HttpSession session = request.getSession();
        session.setAttribute("name", "老付啊");
        return "forward:/ok";
    }

    @GetMapping("/ok")
    @ResponseBody
    public String ok(@RequestAttribute(value = "user", required = false) String username,
                     HttpServletRequest request,
                     @SessionAttribute(value = "name", required = false) String name
    ) {
        //获取到request域中的数据
        System.out.println("user-" + username);
        System.out.println("servlet api 获取username" + request.getAttribute("user"));
        System.out.println("session--" + name);
        System.out.println("request session--" + request.getSession().getAttribute("name"));

        return "success";
    }


    //    响应一个注册请求
    @GetMapping("/register")
    public String register(Map<String, Object> map,
                           Model model,
                           HttpServletResponse response) {
        //如果一个注册请求，会将注册数据封装到map或者model
        //map和model的数据会被放入到request中
        map.put("user","hspedu");
        map.put("job","java架构师");
        model.addAttribute("sal",8000);
        //创建cookie 通过response 添加到浏览器/客户端
        Cookie email = new Cookie("email", "fgr@qq.com");
        response.addCookie(email);

        //请求转发
        return "forward:/registerOk";
    }


    @GetMapping("/registerOk")
    @ResponseBody
    public String registerOk(HttpServletRequest request){
        System.out.println("user- " + request.getAttribute("user"));
        System.out.println("job- " + request.getAttribute("job"));
        System.out.println("sal- " + request.getAttribute("sal"));

        return "success";
    }


}
