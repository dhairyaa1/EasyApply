package com.easyapply.loginservice.jwt;

import com.easyapply.loginservice.models.UserDetails;

public interface AuthenticationService {

	String createToken(UserDetails userDetails);
	
}
