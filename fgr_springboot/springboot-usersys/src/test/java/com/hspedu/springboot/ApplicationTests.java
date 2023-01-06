package com.hspedu.springboot;

import com.hspedu.springboot.bean.Furn;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 如何再springboot开发测试类
 */
@SpringBootTest
public class ApplicationTests {

    //jdbcTemplate
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads(){
        BeanPropertyRowMapper<Furn> rowMapper//封装
                = new BeanPropertyRowMapper<>(Furn.class);

        List<Furn> furns = jdbcTemplate.query("SELECT * FROM furn", rowMapper);

        for (Furn furn : furns) {
            System.out.println(furn);
        }

        //数据源类型HiKariDatasource
        System.out.println(jdbcTemplate.getDataSource());
    }
}
