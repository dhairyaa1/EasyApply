package com.easyapply.userservice.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.easyapply.userservice.entities.UserAccountDetails;

public interface UserAccountService {
	public UserAccountDetails getByUserName(String userName)  throws InterruptedException, ExecutionException;
}
