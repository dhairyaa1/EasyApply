package com.easyapply.userservice.repositories;

import com.easyapply.common.configuration.ConnectionNames;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAccountRepositoryFactory {

    @Autowired
    private UserAccountRepositoryImp easyapplyUserAccountRepositoryImp;

    public UserAccountRepositoryImp getUserAccountRepository(String connectionName)
    {
        if(connectionName.equals(ConnectionNames.easyApply))
        {
            return easyapplyUserAccountRepositoryImp;
        }
        return null;
    }
}
