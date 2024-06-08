package com.easyapply.apigateway.exceptionhandlers;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class ServiceExceptionHandler implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status())
        {
            case 401:
            {
                throw new AuthenticationException();
            }
            default:
            {
                throw new RuntimeException(response.reason());
            }
        }
    }
}
