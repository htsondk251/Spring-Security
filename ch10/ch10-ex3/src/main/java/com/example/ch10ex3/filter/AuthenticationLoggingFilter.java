package com.example.ch10ex3.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;

public class AuthenticationLoggingFilter implements Filter {

    private Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
            
                Object o = request.getAttribute("_csrf");
                CsrfToken token = (CsrfToken) o;

                logger.info("CSRF token " + token.getToken());
                filterChain.doFilter(request, response);
    }
    
}
