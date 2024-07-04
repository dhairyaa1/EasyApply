package com.easyapply.ApplicationDetailsService.services;

import com.easyapply.common.models.applicationservice.ApplicationDetailsRequest;
import com.easyapply.common.models.applicationservice.ApplicationDetailsResponse;

import java.util.concurrent.ExecutionException;

public interface ApplicationDetailsService {
    ApplicationDetailsResponse getApplicationDetails(long userId, long applicationId) throws ExecutionException, InterruptedException ;
    void saveApplicationDetails(ApplicationDetailsRequest applicationDetailsRequest);
}
