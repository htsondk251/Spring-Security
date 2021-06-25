package com.example.ch12ex3.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class MainController {
    private Logger logger = Logger.getLogger(MainController.class.getName());

    @GetMapping("/")
    @ResponseBody
    public String main(OAuth2AuthenticationToken token) {
        logger.info(token.getPrincipal().toString());
        return "Hello there!";
    }
}
