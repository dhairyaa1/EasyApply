package com.easyapply.loginservice.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "app.jwt")
@Getter
@Setter
public class JWTSettings {
	private String clientId;
	private String clientSecret;
	private String signingKey;

	private String issuer;
}
