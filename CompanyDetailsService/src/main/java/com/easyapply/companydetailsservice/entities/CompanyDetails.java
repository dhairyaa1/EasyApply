package com.easyapply.companydetailsservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "company_management")
@Getter
@Setter
public class CompanyDetails {
    public CompanyDetails() {

    }
    private String userID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jobId;
    private String name;
    private String location;
    private String details;

}
