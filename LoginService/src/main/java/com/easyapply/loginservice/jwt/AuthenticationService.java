package com.easyapply.loginservice.jwt;

import com.easyapply.loginservice.entities.UserSecrets;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.ExecutionException;

public interface AuthenticationService {

	String authenticateRequest(UserSecrets secrets) throws ExecutionException, InterruptedException;
	String validateRequest(String token);
}
