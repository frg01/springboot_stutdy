package com.hspedu.springboot.controller;

import com.hspedu.springboot.bean.Monster;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@RestController
public class ParameterController {


    @GetMapping("/monster/{id}/{name}")
    public String pathVariable(@PathVariable(value = "id") Integer id,
                               @PathVariable(value = "name") String name,
                               @PathVariable Map<String, String> map) {
        System.out.println("id--" + id);
        System.out.println("name--" + name);
        System.out.println("map--" + map);
        return "success";
    }


    /**
     * @param host
     * @return
     * @RequestHeader("Host") 获取http请求头的host信息
     * @RequestHeader Map<String, String> header 获取到http请求头的所有信息
     */
    @GetMapping("/requestHeader")
    public String requestHeader(@RequestHeader("Host") String host,
                                @RequestHeader Map<String, String> header,
                                @RequestHeader("accept") String accept
    ) {
        System.out.println("host-" + host);
        System.out.println("header-" + header);
        System.out.println("accept-" + accept);
        return "success";
    }

    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name,
                     @RequestParam(value = "fruit") List<String> fruits,
                     @RequestParam Map<String,String> params
    ) {
        System.out.println("name--" + name);
        System.out.println("fruits--" + fruits);
        System.out.println("map--" + params);
        return "success";
    }

    @GetMapping("/cookie")
    public String cookie(@CookieValue(value = "cookie_key",required = false) String cookie_value,
                         @CookieValue(value = "username",required = false) Cookie cookie,
                         HttpServletRequest request
                         ){
        System.out.println("cookie_value--" + cookie_value);
        System.out.println("username--" + cookie.getName() + "-" + cookie.getValue());
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie1 : cookies) {
            System.out.println("cookie1-" + cookie1.getName() + "=>" + cookie1.getValue());
        }
        return "success";
    }

    @PostMapping("/save")
    public String postMethod(@RequestBody String content){
        System.out.println("content-" + content);
        return "success";
    }


    @PostMapping("/savemonster")
//    @Slf4j
    public String saveMonster(Monster monster){
        System.out.println("monster-" + monster);
        return "success";
    }
}
