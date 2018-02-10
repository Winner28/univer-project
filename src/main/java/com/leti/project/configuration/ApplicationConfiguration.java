package com.leti.project.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import javax.sql.DataSource;


@Configuration
@EnableAutoConfiguration(exclude = MultipartAutoConfiguration.class)
@PropertySource("classpath:/project.properties")
public class ApplicationConfiguration {

    @Value("${com.leti.database.url}")
    private String dataBaseUrl;

    @Value("${com.leti.database.username}")
    private String username;

    @Value("${com.leti.database.password}")
    private String password;

    @Value("${com.leti.database.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .url(dataBaseUrl)
                .username(username)
                .password(password)
                .driverClassName(driverClassName)
                .build();
    }

}