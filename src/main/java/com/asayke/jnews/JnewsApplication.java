package com.asayke.jnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties
public class JnewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(JnewsApplication.class, args);
    }
}