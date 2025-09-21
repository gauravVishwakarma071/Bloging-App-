package com.spring_boot.blog_app;

import com.zaxxer.hikari.HikariDataSource;
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

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setJdbcUrl("jdbc:h2:file:./data/blogdb");
        dataSource.setUsername("gaurav");
        dataSource.setPassword(""); // or leave null if no password
        return dataSource;
    }
}
