package com.easyapply.companydetailsservice.repositories;

import com.easyapply.companydetailsservice.entities.CompanyDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDetailsRepository extends CrudRepository<CompanyDetails,Long > {


}
