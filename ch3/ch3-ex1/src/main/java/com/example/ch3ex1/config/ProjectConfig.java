package com.example.ch3ex1.config;

import java.util.List;
import java.util.stream.Collectors;

import com.example.ch3ex1.model.User;
import com.example.ch3ex1.model.UserDetail;
import com.example.ch3ex1.repository.UserRepository;
import com.example.ch3ex1.service.InMemoryUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ProjectConfig {
    
    @Autowired
    private UserRepository userRepository;

    @Bean
    public UserDetailsService UserDetailsService() {        
        List<UserDetails> users = userRepository.findAll()
            .stream()
            .map(u -> new UserDetail(u))
            .collect(Collectors.toList());
        return new InMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
