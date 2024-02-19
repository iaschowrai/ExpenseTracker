package com.iaschowrai.userauthservice.utils;

import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.time.DateUtils;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;

public class JwtUtils {

    private static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();

    private static final String ET_USER_AUTH_SERVICE = "ET_USER_AUTH_SERVICE";
    private JwtUtils(){
    }

    public static String generateAccessToken(String email) {
        //  issued date
        var issuedAt = new Date();
        //  expiration set for 15 minutes
        var expiration = DateUtils.addMinutes(issuedAt,15);

        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .issuer(ET_USER_AUTH_SERVICE)
                .issuedAt(issuedAt)
                .expiration(expiration)
                .subject(email)
                .signWith(SECRET_KEY)
                .compact();
    }
}
