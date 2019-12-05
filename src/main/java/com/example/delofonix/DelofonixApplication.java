package com.example.delofonix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {
        "classpath:application.properties",
        "classpath:${spring.profiles.active}.properties",
})
public class DelofonixApplication {

    public static void main(String[] args) {
        SpringApplication.run(DelofonixApplication.class, args);
    }

}
