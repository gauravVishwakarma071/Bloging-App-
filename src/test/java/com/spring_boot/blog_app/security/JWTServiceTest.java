package com.spring_boot.blog_app.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JWTServiceTest {

    JWTService jwtService = new JWTService();

    @Test
    void canCreateJwtFromUserId(){
    var jwt = jwtService.createJwt(1001L);

    assertNotNull(jwt);
    }
}
