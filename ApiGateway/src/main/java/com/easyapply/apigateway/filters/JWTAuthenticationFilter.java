package com.easyapply.apigateway.filters;

import com.easyapply.apigateway.services.AuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.naming.AuthenticationException;
import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    AuthenticationService authenticationService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var header = request.getHeader("token");
        if(header == null)
        {
            throw new ServletException();
        }
        else {
             var httpResponse = authenticationService.checkForCredentials(header);
             if(httpResponse.getStatusCode().equals(401))
            {
                throw new ServletException();
            }
             else
             {
                 filterChain.doFilter(request, response);
             }
        }
    }
}
