package com.easyapply.userservice.repositories;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import com.easyapply.common.repositories.DataRepository;
import com.easyapply.userservice.entities.UserAccountDetails;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountRepositoryImp extends DataRepository<UserAccountDetails, Long> implements UserAccountRepository
{
	EntityManager easyapplyEntityManager;

	public UserAccountRepositoryImp(@Qualifier("easyapplyEntityManager") EntityManager entityManager) {
		super(UserAccountDetails.class, entityManager);
        this.easyapplyEntityManager = entityManager;
	}

	public UserAccountDetails getByUserName(String userName) throws InterruptedException, ExecutionException
	{
			var session = easyapplyEntityManager.unwrap(Session.class);

			var query = session.createQuery("select u from UserAccountDetails u where u.userName = :userName", UserAccountDetails.class);
			query.setParameter("userName", userName);
			return query.getSingleResultOrNull();
	}


}

