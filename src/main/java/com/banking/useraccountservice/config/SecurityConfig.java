package com.banking.useraccountservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // your security configuration here
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authz -> authz
                        .dispatcherTypeMatchers(HttpMethod.valueOf("/api/users/**")).authenticated()
                        .anyRequest().permitAll()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

}
