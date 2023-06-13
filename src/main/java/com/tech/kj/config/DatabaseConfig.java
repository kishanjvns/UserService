package com.tech.kj.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
    
    @Value("${spring.datasource.driver-class-name}")
    private String databseDriverClassName;
    
    @Value("${username}")
    private String userName;
    
    @Value("${password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databseDriverClassName);
        dataSource.setUrl(dataSourceUrl);
        return dataSource;
    }
}
