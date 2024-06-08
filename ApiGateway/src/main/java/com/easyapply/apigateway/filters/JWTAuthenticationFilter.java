package com.easyapply.apigateway.filters;

import com.easyapply.apigateway.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JWTAuthenticationFilter implements GlobalFilter {
    @Autowired
    @Lazy
    AuthenticationService authenticationService;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

            var header = exchange.getRequest().getHeaders();
            if (!header.containsKey("token")) {
                exchange.getResponse().setStatusCode(HttpStatusCode.valueOf(401));
                throw new RuntimeException("Unauthorised");
            } else {
                  var httpResponse = authenticationService.checkForCredentials(header.get("token").get(0));

                    return chain.filter(exchange);
                }
            }

    }
