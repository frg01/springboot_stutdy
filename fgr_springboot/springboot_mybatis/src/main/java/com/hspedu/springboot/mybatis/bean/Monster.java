package com.hspedu.springboot.mybatis.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Data
public class Monster {

    private Integer id;
    private Integer age;
    //通过注解解决时区问题  GMT 格林尼治时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date birthday;
    private String email;
    private String name;
    private String gender;
    private Double salary;
}
