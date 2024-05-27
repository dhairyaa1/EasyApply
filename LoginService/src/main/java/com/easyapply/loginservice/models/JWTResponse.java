package com.easyapply.loginservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class JWTResponse {
    private String token;
}
