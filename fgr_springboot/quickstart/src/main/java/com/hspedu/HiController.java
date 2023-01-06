package com.hspedu;

import com.hspedu.springboot.bean.Furn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Slf4j//使用日志输出
@Controller
public class HiController {

    //website 属性从application 的k-v
    @Value("${my.website}")
    private String website;

    //装配到HiController
    @Resource
    private Furn furn;

    @RequestMapping("/hi")
    @ResponseBody
    public String hi() {
        System.out.println("website= " + website);
        return "hi,springboot";
    }

    @RequestMapping("/furn")
    @ResponseBody
    public Furn furn() {
        log.info("furn--" + furn);
        //占位符方式输出
        log.info("furn={} myfurn{}",furn,furn);
        return furn;
    }
}
