package com.workspace.loginservice.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;

import javax.crypto.SecretKey;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.workspace.loginservice.models.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component("authenticationService")
public class AuthenticationServiceImp implements AuthenticationService  {

	
	@Override
	public String createToken(UserDetails userDetails) {
		// TODO Auto-generated method stub
		HashMap<String, Object> claims = new HashMap<>();
		claims.put("userName", userDetails.getUserName());
		claims.put("role", userDetails.getUserRole());
		return Jwts.builder().claims(claims)
				.subject(String.valueOf(userDetails.getUserid()))
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 10  * 60 * 1000))
			.issuer("552523JTBGEWD.workspace.com")
			.signWith(getSigningKey()).compact();
				
	}


	private SecretKey getSigningKey() {
        byte[] keyBytes = "rejregewewh24333333333333526254!#526gsgesg4wt3faege635eh!24s".getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
	
	private Claims extractAllClaims(String token) { 
        return Jwts 
                .parser() 
                .decryptWith(getSigningKey()) 
                .build() 
                .parseSignedClaims(token) 
                .getPayload(); 
    } 
}
