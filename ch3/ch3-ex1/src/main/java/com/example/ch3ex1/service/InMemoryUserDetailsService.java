package com.example.ch3ex1.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InMemoryUserDetailsService implements UserDetailsService {
    private final List<UserDetails> users;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream().filter(u -> username.equals(u.getUsername())).findFirst()
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    
}
