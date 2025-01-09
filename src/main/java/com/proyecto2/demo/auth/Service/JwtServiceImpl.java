//generador del token
package com.proyecto2.demo.auth.Service;

import io.jsonwebtoken.Jwts; // Asegúrate de importar correctamente las clases necesarias
import io.jsonwebtoken.SignatureAlgorithm; // Agrega esto si estás firmando el token
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;


@Service
public class JwtServiceImpl implements JwtService {

    private static final String SECRE_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

    @Override
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }

    private String getToken(HashMap<String, Object> extraClaims, UserDetails user) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte[] keyByte = Base64.getDecoder().decode(SECRE_KEY);
        return Keys.hmacShaKeyFor(keyByte);
    }



}
