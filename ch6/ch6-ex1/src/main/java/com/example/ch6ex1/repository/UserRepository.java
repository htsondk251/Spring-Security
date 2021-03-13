package com.example.ch6ex1.repository;

import java.util.Optional;

import com.example.ch6ex1.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
}
