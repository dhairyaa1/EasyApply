package com.easyapply.companydetailsservice.services;


import com.easyapply.common.models.companyservice.CompanyDetails;

public interface CompanyDetailsService {

    CompanyDetails getCompanyDetails(long id);
    void addCompanyDetails(CompanyDetails companyDetails);

}
