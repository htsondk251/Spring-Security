package com.example.ch2ex2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {
    
    @GetMapping(value="/hello")
    public String Hello() {
        return "Hello!";
    }
    
}
