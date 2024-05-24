package com.easyapply.userservice.controllers;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import com.easyapply.userservice.entities.UserAccountDetails;
import com.easyapply.userservice.services.UserAccountServiceBAL;

@RestController
@RequestMapping("user-details")
public class UserDetailsController {

	@Autowired
	UserAccountServiceBAL userAccountService;
	
	@GetMapping("/{userName}")
	public  ResponseEntity<UserAccountDetails> getUserAccountDetails(@PathVariable String userName) throws InterruptedException, ExecutionException
	{
		System.out.println("main " + Thread.currentThread().getName());
		var future = userAccountService.getByUserName(userName);
		return new ResponseEntity<>( future.get(), HttpStatusCode.valueOf(200));
	}
	@PostMapping()
	public ResponseEntity<UserAccountDetails> saveUserAccountDetails(@RequestBody UserAccountDetails user) throws InterruptedException, ExecutionException
	{
		 return new ResponseEntity<>(userAccountService.save(user), HttpStatusCode.valueOf(200));
	}
}
