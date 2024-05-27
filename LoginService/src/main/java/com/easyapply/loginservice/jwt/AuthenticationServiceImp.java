package com.easyapply.loginservice.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import javax.crypto.SecretKey;

import com.easyapply.loginservice.models.JWTSettings;
import com.easyapply.loginservice.entities.UserSecrets;
import com.easyapply.loginservice.services.UserSecretsService;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthenticationServiceImp implements AuthenticationService  {

    @Autowired
    UserSecretsService userSecretsService;
    @Override
    public String authenticateRequest(UserSecrets secrets) throws ExecutionException, InterruptedException {
        var userSecretsCompletableFuture = userSecretsService.checkCredentials(secrets);
        var userSecrets = userSecretsCompletableFuture.get();
		if(userSecrets == null)
        {
            return null;
        }
        return createToken(userSecrets);

    }

    @Override
    public String validateRequest( String token) {
        if(validateToken(token))
        {
            return token;
        }
        return null;
    }

    @Autowired
	JWTSettings jwtSettings;

	public String createToken(UserSecrets userSecrets) {
		// TODO Auto-generated method stub
		HashMap<String, Object> claims = new HashMap<>();
		claims.put("userName", userSecrets.getUsername());
		claims.put("role", userSecrets.getUserRole());
		claims.put("clientId", jwtSettings.getClientId());
		claims.put("clientSecret", jwtSettings.getClientSecret());
		return Jwts.builder().claims(claims)
				.subject(String.valueOf(userSecrets.getUserid()))
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 10  * 60 * 1000))
			.issuer(jwtSettings.getIssuer())
			.signWith(getSigningKey()).compact();
				
	}


	private SecretKey getSigningKey() {
        byte[] keyBytes = jwtSettings.getSigningKey().getBytes(StandardCharsets.UTF_8);
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



	public Date getExpiration(String token) {
		// Extract and return the expiration claim from the token
		 final Claims claims = extractAllClaims(token);
		 return claims.getExpiration();
	}

	public Boolean isTokenExpired(String token) {
		// Check if the token's expiration time is before the current time
		return getExpiration(token).before(new Date());
	}

	public Boolean validateToken(String token) {
		try {
			var jwt = Jwts.parser().setSigningKey(getSigningKey()).build();
			jwt.parseClaimsJws(token);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}

	}
}
