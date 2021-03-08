package com.example.ch11ex3.repository;

import java.util.Optional;

import com.example.ch11ex3.entity.Otp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, String> {
    Optional<Otp> findOtpByUsername(String username);
}
