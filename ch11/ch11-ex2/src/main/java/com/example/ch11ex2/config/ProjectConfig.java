package com.example.ch11ex2.config;

import com.example.ch11ex2.filter.InitializationAuthenticationFilter;
import com.example.ch11ex2.filter.JwtAuthenticationFilter;
import com.example.ch11ex2.provider.OtpAP;
import com.example.ch11ex2.provider.UsernamePasswordAP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired private InitializationAuthenticationFilter userFilter;
    @Autowired private JwtAuthenticationFilter jwtFilter;
    @Autowired private UsernamePasswordAP userAP;
    @Autowired private OtpAP otpAP;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
       
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(otpAP)
            .authenticationProvider(userAP);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAt(userFilter, BasicAuthenticationFilter.class)
            .addFilterAfter(jwtFilter, BasicAuthenticationFilter.class);

        http.csrf().disable();

        http.authorizeRequests().anyRequest().authenticated();
    }
}
