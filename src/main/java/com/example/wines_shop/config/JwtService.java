package com.example.wines_shop.config;

import com.example.wines_shop.model.account.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private final String SECRET_KEY = "2tiooTHFDTbc9W3uGe2E1uPfyRIk/viiEW1Zbrd16Sp/kp1dhkxH56qcc7VZSabCInrGyf1ZcKoEuByGavbdj66ogUIH7BWA/70G+F5hVjTzDwsOze4rz4/bmdpRq2w+atUApBcir8YhGYvy0nbv+6xS6uLzjYoUjy+4HiLv7zbgVfIo7nEHj0g96RpHYmsry94HOSclNmdHUsJgmTsyo8cj+gVnmaNdK37RwYhpZYlA3t0SjP8HU9wEtI2OFoBeTWHCpG28pA4bUuJJCuOT0rJRNb9MZbQjgsgNWY+aWKy02ATOJuyWS1BS4adYzJ5Na5Xa0Se2NITvxaIBALAGdn5d5pZuLzfV62EhwLao3K0=";

    public String extractUserName(String token) {
        return null;
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {

        return Jwts.builder().setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .claim("role", userDetails.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigninKey())
                .build().parseClaimsJws(token).getBody();
    }

    private Key getSigninKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
