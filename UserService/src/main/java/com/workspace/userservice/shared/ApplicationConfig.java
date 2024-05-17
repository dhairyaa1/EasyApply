package com.workspace.userservice.shared;

import org.springframework.stereotype.Component;

@Component("applicationConfig")
public final class ApplicationConfig {
	
	private  String loginServiceUrl = "";

	public String getLoginServiceUrl() {
		return loginServiceUrl;
	}

	
}
