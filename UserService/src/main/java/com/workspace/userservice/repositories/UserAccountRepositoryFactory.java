package com.workspace.userservice.repositories;

import com.workspace.common.configuration.ConnectionNames;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAccountRepositoryFactory {

    @Autowired
    private UserAccountRepositoryImp workspaceUserAccountRepositoryImp;

    public UserAccountRepositoryImp getUserAccountRepository(String connectionName)
    {
        if(connectionName.equals(ConnectionNames.workSpace))
        {
            return workspaceUserAccountRepositoryImp;
        }
        return null;
    }
}
