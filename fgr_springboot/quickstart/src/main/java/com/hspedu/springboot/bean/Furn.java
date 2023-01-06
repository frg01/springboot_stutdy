package com.hspedu.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 再BeanConfig里使用@EnableConfigurationProperties({Furn.class}),将bean添加到容器
 */
@Component
@ConfigurationProperties(prefix = "furn01")
//@ToString//toString方法
@Data//该注解等价使用了@Getter@Setter@RequiredArgsConstructor@ToString@EqualsAndHashcode//@RequiredArgsConstructor加final替代@Autowired
@NoArgsConstructor//生成无参构造器
@AllArgsConstructor//全参构造器
public class Furn {
    private Integer id;
    private String name;
    private Double price;

}
