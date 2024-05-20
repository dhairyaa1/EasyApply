package com.workspace.userservice.repositories;

import java.util.concurrent.ExecutionException;

import com.workspace.common.repositories.DataRepository;
import com.workspace.userservice.entities.UserSecrets;
import com.workspace.userservice.entities.UserAccountDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountRepositoryImp extends DataRepository<UserAccountDetails, Long> implements UserAccountRepository
{


	EntityManager workspaceEntityManager;

	public UserAccountRepositoryImp(@Qualifier("workspaceEntityManager") EntityManager entityManager) {
		super(UserAccountDetails.class, entityManager);
        this.workspaceEntityManager = entityManager;


	}

	public UserAccountDetails getByUserName(String userName) throws InterruptedException, ExecutionException
	{
		var session = workspaceEntityManager.unwrap(Session.class);

		var query = session.createQuery("select u from UserAccountDetails u where u.userName = :userName", UserAccountDetails.class);
		query.setParameter("userName", userName);
		var list = query.getSingleResultOrNull();
		return list;
	}


}

