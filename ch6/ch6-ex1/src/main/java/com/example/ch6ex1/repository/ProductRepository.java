package com.example.ch6ex1.repository;

import java.util.List;

import com.example.ch6ex1.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // List<Product> findAll();
}
