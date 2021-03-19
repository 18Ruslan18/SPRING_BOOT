package com.company.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "com.company")
@EnableJpaRepositories(basePackages = "com.company.repositories")
@EntityScan("com.company.models")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
