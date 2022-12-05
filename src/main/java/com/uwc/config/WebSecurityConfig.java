package com.uwc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ComponentScan("com.uwc")
public class WebSecurityConfig   {
    //@Autowired
    //private UserDetailsService userDetailService;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	// tạm thời bỏ qua
		return null;
    	//return http.build();
    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
		return null;
    	
    }
}
