package com.easyapply.userservice.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.easyapply.common.configuration.ConnectionNames;
import com.easyapply.userservice.repositories.UserAccountRepository;
import com.easyapply.userservice.repositories.UserAccountRepositoryFactory;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.easyapply.userservice.entities.UserAccountDetails;



@Service
@Transactional
public class UserAccountServiceBAL implements UserAccountService{

	private UserAccountRepository userAccountRepository;

	@Autowired
	public  UserAccountServiceBAL(UserAccountRepositoryFactory userAccountRepositoryFactory)
	{
		this.userAccountRepositoryFactory = userAccountRepositoryFactory;
		userAccountRepository = userAccountRepositoryFactory.getUserAccountRepository(connectionName);
	}
	private UserAccountRepositoryFactory userAccountRepositoryFactory;
	@Setter
	private String connectionName = ConnectionNames.easyApply;


	public CompletableFuture<UserAccountDetails> getByUserName(String userName) throws InterruptedException, ExecutionException
	{
        return userAccountRepository.getByUserName(userName);
	}

	public UserAccountDetails save(UserAccountDetails user) throws InterruptedException, ExecutionException
	{
		return userAccountRepository.save(user);
	}
}
