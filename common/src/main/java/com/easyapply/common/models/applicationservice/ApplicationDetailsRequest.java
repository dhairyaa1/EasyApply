package com.easyapply.common.models.applicationservice;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApplicationDetailsRequest {

    @NotNull
    private long companyId;
    @NotNull
    private String jobDescription;
}
