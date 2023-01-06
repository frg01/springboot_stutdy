package com.hspedu.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Furn {
    private Integer id;
    private String name;
    private String maker;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String imgPath = "assets/images/product-image/1.jpg";
}
