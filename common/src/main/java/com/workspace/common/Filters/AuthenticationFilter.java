package com.workspace.common.Filters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class AuthenticationFilter  implements Filter{


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
			boolean isValid = validateToken(null);
			if(isValid)
				chain.doFilter(request, response);
	}
	
	private SecretKey getSigningKey() {
        byte[] keyBytes = "rejregewewh24333333333333526254!#526gsgesg4wt3faege635eh!24s".getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
	
	public boolean validateToken(String token) {
		try
		{
		JwtParser parser = Jwts.parser()
				.verifyWith(getSigningKey()).build();
		
		Object o =  parser.parse(token);
		 //boolean isTokenExpired = o.().before(new Date()); 
	      
		return  true;
		}
		catch (Exception e) {
			return false;
		}
		
	}

}
