package com.example.ch6ex1.service;

import com.example.ch6ex1.model.SecureUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationProviderService implements AuthenticationProvider {
    @Autowired private JpaUserDetailsService userDetailsService;
    @Autowired private BCryptPasswordEncoder bcryptPasswordEncoder;
    @Autowired private SCryptPasswordEncoder scryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        SecureUser userFromDB = userDetailsService.loadUserByUsername(username);
        switch (userFromDB.getUser().getAlgorithm()) {
            case BCRYPT:
                return checkPassword(userFromDB, password, bcryptPasswordEncoder);
            case SCRYPT:
                return checkPassword(userFromDB, password, scryptPasswordEncoder);
        }
        throw new BadCredentialsException("Bad Credentials");
    }

    private Authentication checkPassword(SecureUser user, String password, PasswordEncoder encoder) {
        // String hashedPassword = encoder.encode(user.getPassword());
        if (encoder.matches(password, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        } else {
            throw new BadCredentialsException("Bad Credentials");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
