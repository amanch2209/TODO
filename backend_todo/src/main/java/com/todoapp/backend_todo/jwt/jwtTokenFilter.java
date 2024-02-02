package com.todoapp.backend_todo.jwt;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.todoapp.backend_todo.CustomExceptions.com.todoapp.backend_todo.CustomExceptions.java.customException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

public class jwtTokenFilter extends GenericFilterBean {
    private jwtTokenGenerator jwtToken;

    public jwtTokenFilter(jwtTokenGenerator jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            String token = jwtToken.resolveToken((HttpServletRequest) req);
            if (token != null && jwtToken.validateToken(token)) {
                Authentication auth = jwtToken.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            filterChain.doFilter(req, res);
        } catch (Exception ex) {
            sendErrorResponse(HttpStatus.BAD_REQUEST, (HttpServletResponse) res, ex);
        }

    }

    private void sendErrorResponse(HttpStatus status, HttpServletResponse res, Exception ex) {

        res.setStatus(status.value());
        res.setContentType("application/json");

        customException customException = new customException(LocalDateTime.now(), status, ex.getMessage());

        try {
            res.getWriter().write(new ObjectMapper().writeValueAsString(customException));
        } catch (IOException e) {

        }
    }
}
