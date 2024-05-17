package com.workspace.userservice.services;

import java.util.concurrent.ExecutionException;

import com.workspace.userservice.entities.UserAccountDetails;

public interface UserAccountService {
	public UserAccountDetails getByUserName(String userName)  throws InterruptedException, ExecutionException;
}
