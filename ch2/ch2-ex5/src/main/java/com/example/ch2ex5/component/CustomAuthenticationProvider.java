package com.example.ch2ex5.component;

import java.util.Arrays;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String password = String.valueOf(auth.getCredentials());

        if ("john".equals(username) && "123".equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());            
        } else {
            throw new AuthenticationCredentialsNotFoundException("Error!");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
    }
    
}
