package com.workspace.userservice.repositories;

import java.util.concurrent.ExecutionException;

import com.workspace.userservice.entities.UserSecrets;
import com.workspace.userservice.entities.UserAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository  extends JpaRepository<UserAccountDetails, Long> {
	
	public UserAccountDetails getByUserName(String userName) throws InterruptedException, ExecutionException;
}
