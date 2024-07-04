package com.easyapply.companydetailsservice.services;

import com.easyapply.common.models.MappingService;
import com.easyapply.common.models.companyservice.CompanyDetails;
import com.easyapply.companydetailsservice.repositories.CompanyDetailsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CompanyDetailsServiceImp implements CompanyDetailsService {


    @Autowired
    MappingService mappingService;
    @Autowired
    CompanyDetailsRepository companyDetailsRepository;
    public CompanyDetails getCompanyDetails(long companyId)
    {
        return mappingService.map(companyDetailsRepository.findById(companyId).orElse(new com.easyapply.companydetailsservice.entities.CompanyDetails()), CompanyDetails.class);
    }
    public void addCompanyDetails(CompanyDetails companyDetails)
    {
        var test = new com.easyapply.companydetailsservice.entities.CompanyDetails();
        var companyDetailsDTO = mappingService.map(companyDetails, com.easyapply.companydetailsservice.entities.CompanyDetails.class);
        companyDetailsRepository.save(companyDetailsDTO);
    }
}
