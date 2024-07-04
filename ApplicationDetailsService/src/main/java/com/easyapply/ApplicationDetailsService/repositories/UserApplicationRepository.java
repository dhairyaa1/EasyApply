package com.easyapply.ApplicationDetailsService.repositories;

import com.easyapply.ApplicationDetailsService.entities.UserApplicationDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApplicationRepository extends CrudRepository<UserApplicationDetails, Long> {

}
