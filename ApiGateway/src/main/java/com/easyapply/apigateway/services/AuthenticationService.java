package com.easyapply.apigateway.services;


import com.easyapply.apigateway.models.UserSecrets;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("LOGINSERVICE")
public interface AuthenticationService {
    @GetMapping("/jwt/validate-token")
    public ResponseEntity checkForCredentials(String token);
    @PostMapping("jwt/create-token")
    public ResponseEntity<String> createToken(UserSecrets userSecrets);
}
