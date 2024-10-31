package com.suranagems.transaction.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**") // Apply CORS to URLs starting with /api/
                .allowedOrigins("*") // Allow all origins temporarily
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
