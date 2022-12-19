package com.example.proyectofct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@EnableFeignClients
@SpringBootApplication
public class ProyectoFctApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoFctApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("*").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
            }
        };
    }

}
