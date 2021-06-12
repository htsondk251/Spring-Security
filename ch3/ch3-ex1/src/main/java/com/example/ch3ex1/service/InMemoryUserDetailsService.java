package com.example.ch3ex1.service;

import java.util.List;

import com.example.ch3ex1.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class InMemoryUserDetailsService implements UserDetailsService {
    private final List<UserDetails> users;

    public InMemoryUserDetailsService(List<UserDetails> users) {
        this.users = users;
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userUuid) throws UsernameNotFoundException {
        return users.stream()
        .filter(u -> userUuid.equals(u.getUsername()))
        .findFirst()
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
