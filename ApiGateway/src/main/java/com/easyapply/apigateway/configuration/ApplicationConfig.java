package com.easyapply.apigateway.configuration;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public HttpMessageConverters httpMessageConverters()
    {
        return new HttpMessageConverters();
    }

}
