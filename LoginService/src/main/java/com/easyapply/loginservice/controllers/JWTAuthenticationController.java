package com.easyapply.loginservice.controllers;

import com.easyapply.loginservice.entities.UserSecrets;
import com.easyapply.loginservice.jwt.AuthenticationServiceImp;
import com.easyapply.loginservice.models.JWTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("jwt")
public class JWTAuthenticationController {

	private final AuthenticationServiceImp authenticationService;
	
	@Autowired
	JWTAuthenticationController(AuthenticationServiceImp authenticationService)
	{
		this.authenticationService = authenticationService;
		 
	}

	@PostMapping("generate-token")
	public ResponseEntity<JWTResponse> getJsonWebToken(@RequestBody UserSecrets userSecrets) throws ExecutionException, InterruptedException {
		return new ResponseEntity<JWTResponse> (
			  new JWTResponse(	authenticationService .authenticateRequest(userSecrets)), HttpStatus.OK);
	}

	@GetMapping("validate-token")
	public ResponseEntity validateJsonWebToken(@RequestHeader String token) throws ExecutionException, InterruptedException {
		String response = authenticationService .validateRequest(token);
		if(response == null)
		{
			return  ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
	}
}
