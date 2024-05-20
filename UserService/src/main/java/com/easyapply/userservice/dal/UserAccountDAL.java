package com.easyapply.userservice.dal;

import com.easyapply.userservice.repositories.UserAccountRepositoryImp;
import jakarta.persistence.EntityManager;

public class UserAccountDAL extends UserAccountRepositoryImp {


    public UserAccountDAL(EntityManager entityManager)
    {
        super(entityManager);
    }

}
