package com.easyapply.loginservice.repositories;

import com.easyapply.loginservice.entities.UserSecrets;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Async
@Repository
public class UserSecretsRepository extends SimpleJpaRepository<UserSecrets, Long> {

    EntityManager entityManager;

    @Autowired
    public UserSecretsRepository( EntityManager entityManager) {
        super(UserSecrets.class, entityManager);
        this.entityManager = entityManager;
    }

    public CompletableFuture<UserSecrets>  checkForCredentials(UserSecrets userSecrets)
    {
        var session = entityManager.unwrap(Session.class);
        var query = session.createQuery("select us from UserSecrets us where us.username = :username and us.password = :password", UserSecrets.class);
        query.setParameter("username", userSecrets.getUsername());
        query.setParameter("password", userSecrets.getPassword());
        var c = query.getSingleResultOrNull();
        return CompletableFuture.completedFuture( query.getSingleResultOrNull());

    }
}
