package com.hspedu.springboot.mybatis.mapper;

import com.hspedu.springboot.mybatis.bean.Monster;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * mapper接口使用@Mapper注解 就会扫描，并将Mapper接口对象注入
 */
@Mapper
public interface MonsterMapper {

    //根据id返回Monster对象
    public Monster getMonsterById(Integer id);
}
