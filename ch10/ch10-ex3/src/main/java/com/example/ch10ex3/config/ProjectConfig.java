package com.example.ch10ex3.config;

import com.example.ch10ex3.filter.AuthenticationLoggingFilter;
import com.example.ch10ex3.repository.CustomCsrfTokenRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public CsrfTokenRepository customTokenRepository() {
        return new CustomCsrfTokenRepository();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        
        http.csrf(c -> {
            c.csrfTokenRepository(customTokenRepository());
            c.ignoringAntMatchers("/ciao");

            // c.csrfTokenRepository(customTokenRepository());
            // HandlerMappingIntrospector i = new HandlerMappingIntrospector();
            // MvcRequestMatcher r = new MvcRequestMatcher(i, "/ciao");
            // c.ignoringRequestMatchers(r);

            // c.csrfTokenRepository(customTokenRepository());
            // String pattern = ".*[0-9].*";
            // String httpMethod = HttpMethod.POST.name();
            // RegexRequestMatcher r = new RegexRequestMatcher(pattern, httpMethod);
            // http.csrf(c -> c.ignoringRequestMatchers(r));
        });

        

        http.authorizeRequests().anyRequest().permitAll();
    }

}
