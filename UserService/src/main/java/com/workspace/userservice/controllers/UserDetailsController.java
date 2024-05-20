package com.workspace.userservice.controllers;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.workspace.userservice.entities.UserAccountDetails;
import com.workspace.userservice.services.UserAccountServiceBAL;

@RestController
@RequestMapping("user-details")
public class UserDetailsController {

	public  UserDetailsController()
	{

	}
	@Autowired
	UserAccountServiceBAL userAccountService;
	
	@GetMapping("/{userName}")
	public ResponseEntity<UserAccountDetails> getUserAccountDetails(@PathVariable String userName) throws InterruptedException, ExecutionException
	{
		return new ResponseEntity<>(userAccountService.getByUserName(userName), HttpStatusCode.valueOf(200));
	}

	@PostMapping()
	public ResponseEntity<UserAccountDetails> saveUserAccountDetails(@RequestBody UserAccountDetails user) throws InterruptedException, ExecutionException
	{
		 return new ResponseEntity<>(userAccountService.save(user), HttpStatusCode.valueOf(200));
	}

}
