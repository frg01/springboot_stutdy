package com.hspedu.fgrspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@RestController
public class FgrHiController {

    @RequestMapping("/fgrhi")
    public String hi(){
        return "hi,fgr  FgrHiController";
    }
}
