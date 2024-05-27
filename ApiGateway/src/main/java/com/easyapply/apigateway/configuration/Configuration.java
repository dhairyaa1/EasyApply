package com.easyapply.apigateway.configuration;

import com.easyapply.apigateway.filters.JWTAuthenticationFilter;
import com.easyapply.apigateway.filters.JWTTokenCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration

public class Configuration extends SecurityConfigurerAdapter {


    @Autowired
    JWTAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    JWTTokenCreation tokenCreation;


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception
    {
        http.csrf(csrf -> csrf.disable()).authorizeRequests().
                requestMatchers("*").authenticated()
                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(tokenCreation))
                .addFilter(jwtAuthenticationFilter);
        return http.build();
    }

}
