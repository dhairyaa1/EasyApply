package com.workspace.loginservice.jwt;

import com.workspace.loginservice.models.UserDetails;

public interface AuthenticationService {

	String createToken(UserDetails userDetails);
	
}
