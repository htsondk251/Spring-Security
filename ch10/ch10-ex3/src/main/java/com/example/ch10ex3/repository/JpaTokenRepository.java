package com.example.ch10ex3.repository;

import java.util.Optional;

import com.example.ch10ex3.entity.Token;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTokenRepository extends JpaRepository<Token, Integer> {
    Optional<Token> findTokenByIdentifier(String identifier);
}
