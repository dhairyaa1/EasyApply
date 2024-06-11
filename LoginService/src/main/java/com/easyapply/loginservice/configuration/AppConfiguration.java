package com.easyapply.loginservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfiguration {



    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security.csrf(AbstractHttpConfigurer::disable).authorizeRequests(expressionInterceptUrlRegistry -> expressionInterceptUrlRegistry.anyRequest().hasIpAddress("0:0:0:0:0:0:0:1")).csrf(AbstractHttpConfigurer::disable).build();
    }
}
