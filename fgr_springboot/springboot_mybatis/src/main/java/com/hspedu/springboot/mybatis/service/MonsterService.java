package com.hspedu.springboot.mybatis.service;

import com.hspedu.springboot.mybatis.bean.Monster;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public interface MonsterService {

    //根据id返回Monster对象
    public Monster getMonsterById(Integer id);
}
