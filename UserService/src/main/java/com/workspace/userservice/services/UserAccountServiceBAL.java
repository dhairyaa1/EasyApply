package com.workspace.userservice.services;

import java.util.concurrent.ExecutionException;

import com.workspace.common.configuration.ConnectionNames;
import com.workspace.userservice.repositories.UserAccountRepository;
import com.workspace.userservice.repositories.UserAccountRepositoryFactory;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import com.workspace.userservice.entities.UserAccountDetails;



@Service
@AllArgsConstructor
@Transactional
public class UserAccountServiceBAL implements UserAccountService{

	private UserAccountRepository userAccountRepository;

	private UserAccountRepositoryFactory userAccountRepositoryFactory;
	@Setter
	private String connectionName = ConnectionNames.workSpace;
	public UserAccountServiceBAL() {
		try {

			userAccountRepository = userAccountRepositoryFactory.getUserAccountRepository(connectionName);
		}
		catch (Exception e)
		{

		}
	}

	public UserAccountDetails getByUserName(String userName) throws InterruptedException, ExecutionException
	{
		return userAccountRepository.getByUserName(userName);
	}

}
