package com.easyapply.common.models.companyservice;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDetails {
    @NotNull
    private String userID;
    @NotNull
    private long jobId;
    @NotNull
    @NotEmpty
    private String name;
    @NotEmpty
    private String location;
    @Max(2000)
    private String details;

}