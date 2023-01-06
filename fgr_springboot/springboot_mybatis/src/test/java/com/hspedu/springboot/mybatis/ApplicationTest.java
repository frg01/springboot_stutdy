package com.hspedu.springboot.mybatis;

import com.hspedu.springboot.mybatis.bean.Monster;
import com.hspedu.springboot.mybatis.mapper.MonsterMapper;
import com.hspedu.springboot.mybatis.service.MonsterService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@SpringBootTest
public class ApplicationTest {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private MonsterMapper monsterMapper;

    @Resource
    private MonsterService monsterService;
    @Test
    public void t1(){
        System.out.println(jdbcTemplate.getDataSource());
    }

    //测试MonsterMapper接口
    @Test
    public void getMonsterById(){
//        Monster monster = monsterMapper.getMonsterById(1);
//        System.out.println("monster--" + monster);
        Monster monster = monsterService.getMonsterById(1);
        System.out.println("monster--" + monster);
    }


}
