package com.easyapply.companydetailsservice.controllers;

import com.easyapply.common.models.ApiResponse;
import com.easyapply.common.models.companyservice.CompanyDetails;
import com.easyapply.companydetailsservice.services.CompanyDetailsServiceImp;
import jakarta.validation.Valid;
import org.modelmapper.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company-details")
public class CompanyDetailsController {

    @Autowired
    CompanyDetailsServiceImp companyDetailsService;
    @GetMapping("/{id}")
    public CompanyDetails getCompanyDetails(@Valid long id)
    {
        return companyDetailsService.getCompanyDetails(id);

    }
    @PostMapping
    public void addCompanyDetails(@Valid @RequestBody CompanyDetails companyDetails)
    {
         companyDetailsService.addCompanyDetails(companyDetails);
    }
}
