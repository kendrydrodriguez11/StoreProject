//generador del token
package com.proyecto2.demo.auth.jwt;

import io.jsonwebtoken.Jwts; // Asegúrate de importar correctamente las clases necesarias
import io.jsonwebtoken.SignatureAlgorithm; // Agrega esto si estás firmando el token
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

public class JwtServiceImpl implements JwtService{

    private static final String SECRE_KEY = "ñknnjjdndndn123nndnd#$%&/ffff";

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
                .signWith(getKey(), SignatureAlgorithm.HS256) // Asumiendo que usas HS256
                .compact(); // Corregido de ginswith a compact
    }

    private Key getKey() {
        byte[] keyByte = Base64.getDecoder().decode(SECRE_KEY);
        return Keys.hmacShaKeyFor(keyByte);
        // Aquí debes definir cómo obtener tu clave para firmar el token
    }



}
