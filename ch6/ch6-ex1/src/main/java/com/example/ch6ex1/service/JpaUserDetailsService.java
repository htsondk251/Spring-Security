package com.example.ch6ex1.service;

import java.util.Optional;

import com.example.ch6ex1.entity.User;
import com.example.ch6ex1.model.SecureUser;
import com.example.ch6ex1.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired private UserRepository userRepository;

    @Override
    public SecureUser loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> uOptional = userRepository.findUserByUsername(username);

        if (uOptional.isPresent()) {
            SecureUser user = new SecureUser(uOptional.get());
            return user;
        } else {
            throw new UsernameNotFoundException("User not exist");
        }
    }


}
