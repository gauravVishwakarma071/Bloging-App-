package com.spring_boot.blog_app.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {
    //TODO: Move the key to a separate .properties file (not in git)

    private static final String JWT_KEY = "dhu45dh37r747fgrf594h5tufb47fh45u";
    private Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);

    public String createJwt(Long userId){
        return JWT.create()
                .withIssuedAt(new Date())
                .withSubject(userId.toString())
                //.withExpiresAt() //TODO: setup expiry parameter
                .sign(algorithm);
    }

    public Long retrieveUserId(String jwtString){
        var decodedJWT = JWT.decode(jwtString);
        return Long.valueOf(decodedJWT.getSubject());
    }
}
