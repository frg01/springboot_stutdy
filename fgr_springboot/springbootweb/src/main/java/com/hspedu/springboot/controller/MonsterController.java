package com.hspedu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
//@RestController
@Controller
public class MonsterController {

    @GetMapping("/monster")
    public String getMonster(){
        return "GET- 查询妖怪";
    }

    @PostMapping("/monster")
    public String saveMonster(){
        return "POST- 添加妖怪";
    }

    @PutMapping("/monster")
    public String updateMonster(){
        return "PUT- 修改妖怪";
    }

//    @RequestMapping(value = "/monster",method = RequestMethod.DELETE)
    @DeleteMapping("/monster")
    public String deleteMonster(){
        return "DELETE- 删除妖怪";
    }

    @RequestMapping("/go")
    public String go(){
        return "hello";//先找相应的controller  没有再去找视图解析器
    }
}
