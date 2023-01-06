package com.hspedu.springboot.mybatisplus.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Configuration
public class DatasourceConfig {

    @ConfigurationProperties(value = "spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }
}
