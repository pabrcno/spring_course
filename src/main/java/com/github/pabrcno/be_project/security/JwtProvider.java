package com.github.pabrcno.be_project.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.stream.Collectors;

import com.github.pabrcno.be_project.config.security.SecurityApplicationProperties;
import com.github.pabrcno.be_project.utils.Constants;

@Component
@RequiredArgsConstructor
public class JwtProvider implements Serializable {

    private final SecurityApplicationProperties properties;

    public String getJWTToken(String username) {
        var grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(Constants.ROLE);

        return Jwts.builder()
                .setSubject(username)
                .claim(Constants.AUTHORITIES,
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + properties.getExpiration()))
                .signWith(SignatureAlgorithm.HS512, properties.getJwtSecret().getBytes())
                .compact();
    }
}
