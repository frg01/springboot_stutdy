package com.hspedu.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monster {
    private Integer id;
    private String name;
    private String skill;
    private Integer age;
    private Double sal;
    private Date birth;
}
