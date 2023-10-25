package com.cotiviti.ecommerce.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtEncoder jwtEncoder;
    @Value("${jwt.expiration.time}")
    private Long jwtExpirationInMillis;

    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return generateTokenWithUserName(principal.getUsername());
    }

    public String generateTokenWithUserName(String username) {
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusMillis(jwtExpirationInMillis))
                .subject(username)
                .claim("scope", (username.equals("sagar10"))?"ROLE_ADMIN":"ROLE_USER")
                .build();

        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public Long getJwtExpirationInMillis() {
        return jwtExpirationInMillis;
    }
}
