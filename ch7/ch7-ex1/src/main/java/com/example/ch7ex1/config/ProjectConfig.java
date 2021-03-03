package com.example.ch7ex1.config;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AcceptAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        var manager = new InMemoryUserDetailsManager();
        var john = User.withUsername("john").password("12345").authorities("READ").build();
        var jane = User.withUsername("jane").password("12345").authorities("WRITE").build();
        
        manager.createUser(john);
        manager.createUser(jane);
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

        http.authorizeRequests().anyRequest()
        // .permitAll()''
        // .hasAuthority("WRITE");
        .hasAnyAuthority("READ", "WRITE");
    }

}
