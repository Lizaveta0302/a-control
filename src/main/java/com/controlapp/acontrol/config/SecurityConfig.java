package com.controlapp.acontrol.config;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**", "/users/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/users/**")
                .permitAll()
                .antMatchers(HttpMethod.PUT, "/users/**")
                .permitAll()
                .antMatchers(HttpMethod.DELETE, "/users/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
