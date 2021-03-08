package com.example.ch11ex3.repository;

import java.util.Optional;

import com.example.ch11ex3.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByUsername(String username);
}
