package com.easyapply.apigateway.services;


import com.easyapply.apigateway.models.UserSecrets;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "${app.services.loginService}", name = "LOGINSERVICE")
public interface AuthenticationService {
    @GetMapping(path = "jwt/validate-token", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> checkForCredentials(@RequestHeader("token") String token);
    @PostMapping(path = "jwt/generate-token" , consumes = "application/json" , produces = "application/json")
    public ResponseEntity<String> createToken(UserSecrets userSecrets);
}
