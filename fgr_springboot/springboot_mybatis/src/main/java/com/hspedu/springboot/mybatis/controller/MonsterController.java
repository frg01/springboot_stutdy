package com.hspedu.springboot.mybatis.controller;

import com.hspedu.springboot.mybatis.bean.Monster;
import com.hspedu.springboot.mybatis.service.MonsterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Controller
public class MonsterController {

    //装配monsterService
    @Resource
    private MonsterService monsterService;

    @GetMapping("/monster")
    @ResponseBody
    public Monster getMonsterById(@RequestParam("id") Integer id){

        return monsterService.getMonsterById(id);
    }
}
