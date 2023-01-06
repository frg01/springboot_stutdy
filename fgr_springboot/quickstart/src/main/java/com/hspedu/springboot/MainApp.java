package com.hspedu.springboot;

import com.hspedu.springboot.bean.A;
import com.hspedu.springboot.bean.Cat;
import com.hspedu.springboot.bean.Dog;
import com.hspedu.springboot.bean.Monster;
import com.hspedu.springboot.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * @SpringBootApplication 用来表示这是一个springboot应用
 * scanBasePackages 指定springboot要扫描的包和子包
 */
@SpringBootApplication(scanBasePackages = {"com.hspedu"})//可以使用数组方式指定{"","",""}
public class MainApp {
    public static void main(String[] args) {
        //启动springboot应用程序
        ConfigurableApplicationContext ioc =
                SpringApplication.run(MainApp.class, args);
        //如何查看容器中注入的组件
//        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println("beanDefinitionName= " + beanDefinitionName);
//        }

        //spring中传统的注解可以使用@Controller @Service @Repository
//        A aBean = ioc.getBean(A.class);
//        System.out.println("aBean= " + aBean);

        //springboot项目中,依然可以使用spring的配置bean/注入bean/获取bean
//        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//        Monster monster03 = ac.getBean("monster03", Monster.class);
//        System.out.println("monster03 =" + monster03);

        //演示@Configuration start
//        Monster monster01 = ioc.getBean("monster01", Monster.class);
//        Monster monster02 = ioc.getBean("monster01", Monster.class);
//        System.out.println("monster01 --" + monster01.hashCode());
//        System.out.println("monster02 --" + monster02.hashCode());

        //配置类也会注入到容器
//        BeanConfig bean = ioc.getBean(BeanConfig.class);
//        System.out.println("BeanConfig--" + bean);

        //@Configuration(proxyBeanMethods = true/false)
//        BeanConfig beanConfig = ioc.getBean(BeanConfig.class);
//        Monster monster01 = beanConfig.monster01();
//        Monster monster02 = beanConfig.monster01();
//
//        Monster monster021 = ioc.getBean("monster02", Monster.class);
//        System.out.println("monster021--" + monster021);


        //@Import 注解的使用
//        Dog dogBean = ioc.getBean(Dog.class);
//        Cat catBean = ioc.getBean(Cat.class);
//        System.out.println("dogBean" + dogBean);
//        System.out.println("catBean" + catBean);

        //演示@ConditionOnBean 使用
//        Dog dog01 = ioc.getBean("dog01", Dog.class);
//        System.out.println("dog01--" + dog01);

        //演示@ImportResource的使用
        Monster monster03 = ioc.getBean("monster03", Monster.class);
        System.out.println("monster03= " + monster03);
        System.out.println("monster04是否存在:" + ioc.containsBean("monster04"));
    }
}
