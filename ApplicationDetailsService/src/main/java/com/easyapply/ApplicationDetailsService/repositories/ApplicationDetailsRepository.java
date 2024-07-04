package com.easyapply.ApplicationDetailsService.repositories;

import com.easyapply.ApplicationDetailsService.entities.ApplicationDetails;

public interface ApplicationDetailsRepository {

    ApplicationDetails getApplicationDetails(long userId, long applicationId);
}
