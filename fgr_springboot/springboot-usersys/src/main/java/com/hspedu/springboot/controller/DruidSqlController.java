package com.hspedu.springboot.controller;

import com.hspedu.springboot.bean.Furn;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Controller
public class DruidSqlController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/sql")
    public List<Furn> crudDB(){
        BeanPropertyRowMapper<Furn> rowMapper = new BeanPropertyRowMapper<>(Furn.class);
        List<Furn> furns = jdbcTemplate.query("SELECT * FROM `furn`", rowMapper);

        for (Furn furn : furns) {
            System.out.println(furn);
        }
        return furns;
    }
}
