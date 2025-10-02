package com.spring_boot.blog_app.security;

import com.spring_boot.blog_app.users.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@AllArgsConstructor
public class JWTAuthenticationManager implements AuthenticationManager {

    private final JWTService jwtService;
    private UsersService usersService;

    public JWTAuthenticationManager(JWTService jwtService){
        this.jwtService = jwtService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if(authentication instanceof JWTAuthenticaiton){
            var jwtAuthenticaiton = (JWTAuthenticaiton) authentication;
            var jwt = jwtAuthenticaiton.getCredentials();
            var userId = jwtService.retrieveUserId(jwt);

            jwtAuthenticaiton.userEntity = usersService.getUserById(userId);
            jwtAuthenticaiton.setAuthenticated(true);
            return jwtAuthenticaiton;
        }
        return null;
    }
}
