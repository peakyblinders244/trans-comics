package com.transcomics.transcomics.config;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Le-Hong-Quan
 * Date: 25/05/2024
 * Time: 13:19
 */
@Configuration
@Slf4j
public class FlyWayConfig {
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
    @Value("${spring.datasource.username}")
    private String dataSourceUsername;
    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Value("${spring.flyway.locations}")
    private String[] locations;


    @Bean
    public Flyway flyway() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource())
                .locations(locations)
                .baselineOnMigrate(true)
                .baselineVersion("0")
                .load();
        log.info("Flyway migration started");
        flyway.migrate();
        return flyway;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUsername);
        dataSource.setPassword(dataSourcePassword);
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }
}
