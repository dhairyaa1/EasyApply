package com.easyapply.ApplicationDetailsService.controllers;

import com.easyapply.ApplicationDetailsService.entities.UserApplicationDetails;
import com.easyapply.ApplicationDetailsService.services.ApplicationDetailsServiceImp;
import com.easyapply.ApplicationDetailsService.services.UserApplicationServiceImp;
import com.easyapply.common.models.applicationservice.ApplicationDetailsRequest;
import com.easyapply.common.models.applicationservice.ApplicationDetailsResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("application-details")
public class ApplicationDetailsController {

    @Autowired
    ApplicationDetailsServiceImp applicationDetailsService;
    @Autowired
    UserApplicationServiceImp userApplicationService;
    @GetMapping("/{userId}/{applicationId}")
    public ApplicationDetailsResponse getApplicationDetails(@Valid long userId, @Valid long applicationId, BindingResult result) throws ExecutionException, InterruptedException {
        if(!result.hasErrors())
            return applicationDetailsService.getApplicationDetails(userId, applicationId);
        return null;
    }
    @PostMapping("submit-user-application")
    public void submitApplicationDetails(@RequestBody UserApplicationDetails userApplicationDetails) throws ExecutionException, InterruptedException {
         userApplicationService.submitApplication(userApplicationDetails);
    }
    @PostMapping
    public void createApplication(@RequestBody ApplicationDetailsRequest applicationDetailsRequest) throws ExecutionException, InterruptedException {
        applicationDetailsService.saveApplicationDetails(applicationDetailsRequest);
    }
}
