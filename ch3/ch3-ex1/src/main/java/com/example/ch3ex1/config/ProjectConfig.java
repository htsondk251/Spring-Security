package com.example.ch3ex1.config;

import java.util.List;

import com.example.ch3ex1.model.User;
import com.example.ch3ex1.service.InMemoryUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ProjectConfig {
    @Bean
    public UserDetailsService UserDetailsService() {
        var userSon = new User("son", "123", "read");
        List<UserDetails> users = List.of(userSon);
        return new InMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
