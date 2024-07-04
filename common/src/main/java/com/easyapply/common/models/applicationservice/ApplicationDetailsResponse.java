package com.easyapply.common.models.applicationservice;

import com.easyapply.common.models.companyservice.CompanyDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationDetailsResponse {
    private long applicationId;
    private long jobDescription;
    private CompanyDetails companyDetails;
}