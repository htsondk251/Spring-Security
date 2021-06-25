package com.example.ch12ex1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login();
        http.authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        var c = clientRegistration();
        return new InMemoryClientRegistrationRepository(c);
    }

    private ClientRegistration clientRegistration() {
        return CommonOAuth2Provider.GITHUB
                .getBuilder("gitHub")
                .clientId("3ce968705a13c12c0bc1")
                .clientSecret("7e1551481a600b4af39bae526a54d25e10e01a14")
                .build();
    }

//    private ClientRegistration clientRegistration = ClientRegistration.withRegistrationId("gitHub")
//            .clientId("3ce968705a13c12c0bc1")
//            .clientSecret("7e1551481a600b4af39bae526a54d25e10e01a14")
//            .scope(new String[]{"read:user"})
//            .authorizationUri("https://github.com/login/oauth/authorize")
//            .tokenUri("https://github.com/login/oauth/access_token")
//            .userInfoUri("https://api.github.com/user")
//            .userNameAttributeName("id")
//            .clientName("GitHub")
//            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//            .redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}")
//            .build();

//    private ClientRegistration clientRegistration = CommonOAuth2Provider.GITHUB
//            .getBuilder("gitHub")
//            .clientId("3ce968705a13c12c0bc1")
//            .clientSecret("7e1551481a600b4af39bae526a54d25e10e01a14")
//            .build();




}
