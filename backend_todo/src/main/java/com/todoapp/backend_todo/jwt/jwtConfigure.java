package com.todoapp.backend_todo.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class jwtConfigure extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private jwtTokenGenerator jwtToken;

    public jwtConfigure(jwtTokenGenerator jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        jwtTokenFilter customFilter = new jwtTokenFilter(jwtToken);
        httpSecurity.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
