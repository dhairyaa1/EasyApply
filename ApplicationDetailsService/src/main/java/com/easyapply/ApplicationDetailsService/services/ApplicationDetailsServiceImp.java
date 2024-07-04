package com.easyapply.ApplicationDetailsService.services;

import com.easyapply.ApplicationDetailsService.repositories.ApplicationDetailsRepositoryImp;
import com.easyapply.common.models.MappingService;
import com.easyapply.common.models.applicationservice.ApplicationDetailsRequest;
import com.easyapply.common.models.applicationservice.ApplicationDetailsResponse;
import com.easyapply.common.models.companyservice.CompanyDetails;
import com.easyapply.common.services.HttpService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class ApplicationDetailsServiceImp implements ApplicationDetailsService {

    @Autowired
    MappingService mappingService;
    @Value("${spring:application:apiSettings:companyDetailsService:baseUrl}")
    public String baseUrl;
    @Autowired
    HttpService httpService;
    @Autowired
    ApplicationDetailsRepositoryImp applicationDetailsRepository;

    @Override
    public void saveApplicationDetails(ApplicationDetailsRequest applicationDetailsRequest)
    {
        var applicationDetailsDTO = mappingService.map(applicationDetailsRequest, com.easyapply.ApplicationDetailsService.entities.ApplicationDetails.class);
        applicationDetailsRepository.save(applicationDetailsDTO);
    }
    @Override
    public ApplicationDetailsResponse getApplicationDetails(long userId, long applicationId) throws ExecutionException, InterruptedException {
        var applicationDetailsFuture = CompletableFuture.supplyAsync(() ->
        {
            return applicationDetailsRepository.getApplicationDetails(userId, applicationId);
        });


        CompletableFuture<CompanyDetails> jobDetailsFuture = null;
        try {
            jobDetailsFuture = httpService.get(baseUrl, CompanyDetails.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return applicationDetailsFuture.thenCombine(jobDetailsFuture, (applicationDetails, jobDetails) ->
        {
            var returnObj = (ApplicationDetailsResponse) mappingService.map(applicationDetails, ApplicationDetailsResponse.class);
            returnObj.setCompanyDetails((CompanyDetails) jobDetails);
            return returnObj;
        }).get();

    }

}
