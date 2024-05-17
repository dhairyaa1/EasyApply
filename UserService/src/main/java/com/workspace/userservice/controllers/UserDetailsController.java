package com.workspace.userservice.controllers;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.workspace.userservice.entities.UserAccountDetails;
import com.workspace.userservice.services.UserAccountServiceBAL;

@RestController
@RequestMapping("user-details/")
public class UserDetailsController {

	public  UserDetailsController()
	{

	}
	@Autowired
	UserAccountServiceBAL userAccountService;
	
	@GetMapping("/{userName}")
	public UserAccountDetails getUserAccountDetails(@PathVariable String userName) throws InterruptedException, ExecutionException
	{
		return userAccountService.getByUserName(userName);
	}


}
