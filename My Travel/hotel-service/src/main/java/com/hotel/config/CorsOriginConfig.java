package com.hotel.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class CorsOriginConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("addCorsMappings(CorsRegistry) -> | Registry : {}",registry);
        registry.addMapping("/hotel/**")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
        log.info("addCorsMappings(CorsRegistry) -> | After Config Registry : {}",registry);
    }
}
