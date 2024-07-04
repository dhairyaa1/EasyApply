package com.easyapply.apigateway.controllers;

import com.easyapply.apigateway.models.UserSecrets;
import com.easyapply.apigateway.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;
    @PostMapping
    public ResponseEntity<String> getAuthentication(@RequestBody UserSecrets userSecrets)
    {

       return authenticationService.createToken(userSecrets);
    }
}
