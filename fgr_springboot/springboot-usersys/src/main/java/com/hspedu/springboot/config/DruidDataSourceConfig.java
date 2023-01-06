package com.hspedu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * DruidDataSourceConfig是一个配置类 是配置的一种方法 另一种页可以引入druid-starter
 */
@Configuration
public class DruidDataSourceConfig {
//    注入DruidDataSource后，原来的HikariDatasource就失效了
    //默认的数据源 使用注解@ConditionMissingBean如果有Datasource就不使用原来的Datasource
    @ConfigurationProperties("spring.datasource")//就可以读取application.yml的配置
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();
//        druidDataSource.setDriver();
        //加入监控功能 ,加入sql防火墙
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    //配置Druid的监控页功能
    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean
                = new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        //设置init-parameter  用户名和密码 k值固定
        registrationBean.addInitParameter("loginUsername","fgr");
        registrationBean.addInitParameter("loginPassword","666666");
        return registrationBean;

    }

    //配置WebStatFilter，用于采集web-jdbc关联的监控数据
    @Bean
    public FilterRegistrationBean webStatFilter(){
        //创建webStatFilter
        WebStatFilter webStatFilter = new WebStatFilter();

        FilterRegistrationBean<WebStatFilter> filterRegistrationBean
                = new FilterRegistrationBean<>(webStatFilter);
        //默认对所有url请求进行监控
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        //排除指定url
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ioc,/druid/*");
        return filterRegistrationBean;

    }
}
