package com.example.ch5ex4.config;

import com.example.ch5ex4.security.CustomAuthenticationFailureHandler;
import com.example.ch5ex4.security.CustomAuthenticationSuccessHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired private CustomAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired private CustomAuthenticationSuccessHandler authenticationSuccessHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
        // .defaultSuccessUrl("/home", true);
        .successHandler(authenticationSuccessHandler)
        .failureHandler(authenticationFailureHandler)
        .and()
            .httpBasic();

        http.authorizeRequests().anyRequest().authenticated();
    }
}
