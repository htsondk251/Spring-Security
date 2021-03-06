package com.example.ch10ex1.config;

import com.example.ch10ex1.filter.CsrfTokenLogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
        
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class)
            .authorizeRequests().anyRequest().permitAll();
    }
}
