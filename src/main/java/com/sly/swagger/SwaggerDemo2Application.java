package com.sly.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class SwaggerDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerDemo2Application.class, args);
    }

}
