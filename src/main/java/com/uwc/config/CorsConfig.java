package com.uwc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
// CORSE GLOBAL Config
@Configuration
public class CorsConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/api/**")
			.allowedOrigins("*")
			.allowedMethods("POST", "PUT", "GET", "DELETE")
			.allowCredentials(false)
			.maxAge(4800);
	}

}
*/