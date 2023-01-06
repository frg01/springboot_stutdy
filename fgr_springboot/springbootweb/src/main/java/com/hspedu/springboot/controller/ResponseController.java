package com.hspedu.springboot.controller;

import com.hspedu.springboot.bean.Car;
import com.hspedu.springboot.bean.Monster;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
*@author: guorui fu
*@versiion: 1.0
*/
@Controller
public class ResponseController {

    //返回Monster数据 以json数据返回
    @GetMapping("/get/monster")
    @ResponseBody
    public Monster getMonster(){

        Monster monster = new Monster();
        monster.setId(100);
        monster.setName("小王");
        monster.setAge(200);
        monster.setIsMarried(false);
        monster.setBirth(new Date());
        Car car = new Car();
        car.setName("翼龙");
        car.setPrice(23000.5);
        monster.setCar(car);
        return monster;

    }
}
