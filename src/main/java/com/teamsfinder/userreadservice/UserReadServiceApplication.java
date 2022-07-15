package com.teamsfinder.userreadservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserReadServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserReadServiceApplication.class, args);
    }

}
