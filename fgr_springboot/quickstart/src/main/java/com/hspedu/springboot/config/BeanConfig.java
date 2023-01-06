package com.hspedu.springboot.config;
import com.hspedu.springboot.bean.Cat;
import com.hspedu.springboot.bean.Dog;
import com.hspedu.springboot.bean.Furn;
import com.hspedu.springboot.bean.Monster;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */

//@Configuration 标识这时一个配置类  等价于配置文件
//可以通过@Bean 注入bean对象到容器
@Configuration(proxyBeanMethods = true)
@Import({Dog.class, Cat.class}) //可以指定class数组,注入指定类型的Bean 默认组件名/id是全类名
//@ConditionalOnBean(name = "monster_nmw")//对配置类所有bean进行条件约束
//@EnableConfigurationProperties({Furn.class})//将Furn对象注入容器
public class BeanConfig {

    /**
     * @Bean  给容器太添加组件 就是Monster bean
     * monster01() 默认方法名作为Bean的名字/id
     * Monster 注入类型,注入bean的类型是Monster
     * name = "mosnter_nmw" 配置注入Bean指定了名字
     * 默认是单例注入
     *  @Scope("prototype") 每次返回新的对象 多例模式
     * @return
     */
//    @Bean(name = "monster_nmw")
    @Bean
//    @Scope("prototype")
    public Monster monster01(){
        return new Monster(200,"牛魔王",500,"牛角");
    }

    @Bean
    /**@ConditionalOnBean(name = "monster_nmw")
     *当容器中有一个Bean,名字是monster_nmw 就注入dog01,如果没有就不注入
     * 还有其他条件约束注解
     */
//    @ConditionalOnBean(name = "monster_nmw")
//    @ConditionalOnMissingBean(name = "monster_nmw")//没有monster_nmw才注入
    public Dog dog01(){
        return new Dog();
    }
}
