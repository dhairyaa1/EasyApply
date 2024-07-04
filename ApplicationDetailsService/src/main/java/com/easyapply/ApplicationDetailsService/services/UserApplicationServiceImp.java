package com.easyapply.ApplicationDetailsService.services;

import com.easyapply.ApplicationDetailsService.entities.UserApplicationDetails;
import com.easyapply.ApplicationDetailsService.repositories.UserApplicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserApplicationServiceImp implements UserApplicationService{
   @Autowired
    UserApplicationRepository userApplicationRepository;
    @Override
    public void submitApplication(UserApplicationDetails userApplicationDetails) {
        userApplicationRepository.save(userApplicationDetails);
    }
}
