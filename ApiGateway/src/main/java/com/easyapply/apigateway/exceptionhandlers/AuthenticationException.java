package com.easyapply.apigateway.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;


@Component
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Not authorized to process this request")
public class AuthenticationException extends RuntimeException {

    public AuthenticationException()
    {
        super();
    }
}
