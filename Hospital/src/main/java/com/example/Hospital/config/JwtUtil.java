package com.example.Hospital.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;

@Configuration
public class JwtUtil {

    private static final String SECRET_KEY = "salut";
    private static final long expirare = 8640000;

    public String getSecretKey(String username){
        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expirare))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }
    public String extragereUsername(String token){
        return extractClaims(token,Claims::getSubject);
    }

    public Claims extragereTotClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJwt(token).getBody();
    }

    public <T> T extractClaims(String token, Function<Claims,T> claimsTFunction){
        final Claims claims = extragereTotClaims(token);
        return (T) extragereTotClaims(token);

    }


    public String isTokenExpire(String token){
        return extragereUsername(token);
    }

    public boolean validateToken(String token, String username){
        return username.equals(extragereUsername(token));
    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username = extragereUsername(token);
        return  username.equals(userDetails.getUsername());
    }
}
