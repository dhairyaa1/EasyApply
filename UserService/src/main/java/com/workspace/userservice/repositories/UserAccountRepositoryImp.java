package com.workspace.userservice.repositories;

import java.util.concurrent.ExecutionException;

import com.workspace.common.repositories.DataRepository;
import com.workspace.userservice.entities.UserSecrets;
import com.workspace.userservice.entities.UserAccountDetails;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountRepositoryImp extends DataRepository<UserAccountDetails, Long> implements UserAccountRepository
{

	@Autowired
	EntityManager entityManager;

	public UserAccountRepositoryImp(EntityManager entityManager) {
		super(UserAccountDetails.class, entityManager);
        Configuration cfg = new Configuration();


	}

	public UserAccountDetails getByUserName(String userName) throws InterruptedException, ExecutionException
	{
		var session = entityManager.unwrap(Session.class);
		var transaction = session.beginTransaction();

		var query = session.createQuery("from userAccountDetails where userName = :userName", UserAccountDetails.class);
		query.setParameter("userName", userName);
		var list = query.getSingleResultOrNull();
		transaction.commit();
		return list;
	}
}

