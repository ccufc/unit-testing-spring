package com.app.backend.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DbConfiguration {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    // @Bean
    // DataSource dataSource() {
    // DriverManagerDataSource ds = new DriverManagerDataSource();

    // ds.setUrl(url);
    // ds.setDriverClassName(driver);
    // ds.setUsername(username);
    // ds.setPassword(password);

    // return ds;
    // }

    @Bean
    DataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(url);
        config.setDriverClassName(driver);
        config.setUsername(username);
        config.setPassword(password);

        config.setMinimumIdle(1);
        config.setMaximumPoolSize(10);
        config.setMaxLifetime(600000);
        config.setConnectionTimeout(120000);
        config.setConnectionTestQuery("select 1");

        return new HikariDataSource(config);
    }
}
