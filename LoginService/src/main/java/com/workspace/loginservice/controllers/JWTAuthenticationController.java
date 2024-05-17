package com.workspace.loginservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workspace.common.Filters.AuthenticationFilter;
import com.workspace.loginservice.jwt.AuthenticationServiceImp;
import com.workspace.loginservice.models.UserDetails;

@RestController
@RequestMapping("jwt")
public class JWTAuthenticationController {

	private final AuthenticationServiceImp authenticationService;
	
	@Autowired
	JWTAuthenticationController(AuthenticationServiceImp authenticationService)
	{
		this.authenticationService = authenticationService;
		 
	}
	
	@Async
	@PostMapping("generate-token")
	public ResponseEntity<String> getJsonWebToken(@RequestBody UserDetails userDetails)
	{
		return new ResponseEntity<String> (
				authenticationService .createToken(userDetails), HttpStatus.OK);
	}
	
}
