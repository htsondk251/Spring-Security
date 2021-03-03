package com.example.ch8ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();
        var john = User.withUsername("john").password("12345").roles("ADMIN").build();
        var jane = User.withUsername("jane").password("12345").roles("MANAGER").build();
        
        userDetailsService.createUser(john);
        userDetailsService.createUser(jane);

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

        http.csrf().disable();

        http.authorizeRequests()
            .mvcMatchers(HttpMethod.GET, "/a/b").permitAll()
            .mvcMatchers(HttpMethod.GET, "/a").authenticated()
            .mvcMatchers(HttpMethod.POST, "/a").permitAll()
            // mvcMatchers(HttpMethod.GET, "/a/b").
            .anyRequest().denyAll();

    }
}
