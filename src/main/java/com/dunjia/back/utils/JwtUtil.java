package com.dunjia.back.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

public class JwtUtil {

    private static long time = 1000 * 60 * 60 * 24; // 24 hour
    private static String signature = "dunjia";

    /**
     * 生成token
     * @return
     */
    public static String createToken() {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                // header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // payload
                .claim("username", "admin")
                .claim("password", "admin")
                .setSubject("jwt-token")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                // signature
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        return jwtToken;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static boolean verifyToken(String token) {
        if (token == null) {
            return false;
        }
        try {
            Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
