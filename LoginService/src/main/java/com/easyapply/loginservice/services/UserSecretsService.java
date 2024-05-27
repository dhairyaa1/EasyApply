package com.easyapply.loginservice.services;

import com.easyapply.loginservice.entities.UserSecrets;
import com.easyapply.loginservice.repositories.UserSecretsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UserSecretsService {
    @Autowired
    UserSecretsRepository userSecretsRepository;

    public CompletableFuture<UserSecrets> checkCredentials(UserSecrets userSecrets)
    {
        return userSecretsRepository.checkForCredentials(userSecrets);
    }
}
