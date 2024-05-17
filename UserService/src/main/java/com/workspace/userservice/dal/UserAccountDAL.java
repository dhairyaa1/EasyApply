package com.workspace.userservice.dal;

import com.workspace.userservice.repositories.UserAccountRepositoryImp;
import jakarta.persistence.EntityManager;

public class UserAccountDAL extends UserAccountRepositoryImp {


    public UserAccountDAL(EntityManager entityManager)
    {
        super(entityManager);
    }

}
