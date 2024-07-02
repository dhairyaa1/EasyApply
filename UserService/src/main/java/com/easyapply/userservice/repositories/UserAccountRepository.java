package com.easyapply.userservice.repositories;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.easyapply.userservice.entities.UserAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository  extends JpaRepository<UserAccountDetails, Long> {
	
	public UserAccountDetails getByUserName(String userName) throws InterruptedException, ExecutionException;
}
