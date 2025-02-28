package org.iesch.ad.LoginYJWT.jwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTutil {

    private final long jwtExpiration = 86400000;
    @Value("${jwt.secret}")
    private String secret;

    public SecretKey getSigningKey() {
        byte[] keyBytes = secret.getBytes();

        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractClaimExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Boolean isTokenExpired(String token) {
        return extractClaimExpiration(token).before(new Date());
    }

    private Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);

        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    public String generateMyToken(String username) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("apellido", "Julve");
        claims.put("telefono", 456321852);
        claims.put("direccion", "Calle sin numero, 2");
        claims.put("dni", "18456278C");

        return createToken(claims, username);
    }

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpiration);
        String token = Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(expireDate)
                .signWith(getSigningKey())
                .compact();

//        Map<String, Object> claims = new HashMap<>();
//
//        claims.put("apellido", "Julve");
//        claims.put("telefono", 456321852);
//        claims.put("direccion", "Calle sin numero, 2");
//        claims.put("dni", "18456278C");
//
//        return createToken(claims, username);
        return token;
    }

    public String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(getSigningKey())
                .compact();
    }

    public Boolean validaToken(String token) {
        return validateToken(token, extractUsername(token));
    }
}
