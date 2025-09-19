package com.spring_boot.blog_app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class jpaTestConfig {

    @Bean
    @Profile("test")
    public DataSource dataSource(){

        var dataSourse = new DriverManagerDataSource();
        dataSourse.setDriverClassName("org.h2.Driver");
        dataSourse.setUrl("jdbc:h2:file:./data/blogdb:DB_CLOSE_DELAY=-1");
        return dataSource();
    }
}
