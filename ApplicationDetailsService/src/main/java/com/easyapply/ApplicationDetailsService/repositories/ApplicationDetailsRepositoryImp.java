package com.easyapply.ApplicationDetailsService.repositories;

import com.easyapply.ApplicationDetailsService.entities.ApplicationDetails;
import com.easyapply.common.repositories.DataRepository;
import com.easyapply.common.storedprocedurenames.ApplicationDetailsStoredProcedures;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationDetailsRepositoryImp extends DataRepository<ApplicationDetails, Long> implements ApplicationDetailsRepository  {
    EntityManager entityManager;
    @Autowired
    public ApplicationDetailsRepositoryImp( EntityManager entityManager) {
        super(ApplicationDetails.class, entityManager);
        this.entityManager = entityManager;

    }

    @Override
    public ApplicationDetails getApplicationDetails(long userId, long applicationId) {
        var session = entityManager.unwrap(Session.class);
        var query = session.createStoredProcedureQuery("exec " + ApplicationDetailsStoredProcedures.applicationDetailsByUser, ApplicationDetails.class);
        query.setParameter("@userId", userId);
        query.setParameter("@applicationId", applicationId);
        return (ApplicationDetails) query.getSingleResult();
    }
}
