package com.hspedu.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private String name;
    private String password;
}
