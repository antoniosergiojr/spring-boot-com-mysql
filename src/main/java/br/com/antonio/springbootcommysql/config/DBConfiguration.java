package br.com.antonio.springbootcommysql.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDatabaseConnection() {
        System.out.println("DB connection for MYSQL Database: localhost");
        System.out.println(driverClassName);
        System.out.println(url);
        //System.out.println(username);
        //System.out.println(password);
        return "DB Connection to MySql localhost - Test instance";
    }

    @Profile("prod")
    @Bean
    public String prodDatabaseConnection() {
        System.out.println("DB connection for MYSQL Database: production");
        System.out.println(driverClassName);
        System.out.println(url);
        //System.out.println(username);
        //System.out.println(password);
        return "DB Connection to MySql production - Test instance";
    }
}
