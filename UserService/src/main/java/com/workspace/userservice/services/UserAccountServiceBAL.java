package com.workspace.userservice.services;

import java.util.concurrent.ExecutionException;

import com.workspace.common.configuration.ConnectionNames;
import com.workspace.userservice.repositories.UserAccountRepository;
import com.workspace.userservice.repositories.UserAccountRepositoryFactory;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.workspace.userservice.entities.UserAccountDetails;



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
	private String connectionName = ConnectionNames.workSpace;


	public UserAccountDetails getByUserName(String userName) throws InterruptedException, ExecutionException
	{
		return userAccountRepository.getByUserName(userName);
	}
	public UserAccountDetails save(UserAccountDetails user) throws InterruptedException, ExecutionException
	{
		return userAccountRepository.save(user);

	}
}
