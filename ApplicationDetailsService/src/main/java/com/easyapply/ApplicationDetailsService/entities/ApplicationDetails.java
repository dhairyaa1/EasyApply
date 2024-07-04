package com.easyapply.ApplicationDetailsService.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "application_details")
public class ApplicationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long applicationId;
    private long companyId;
    private String jobDescription;

}
