package com.example.security_concepts;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated())

                
                .httpBasic(httpBasic -> {}) // aaplies default basic security settings
                .build();
    }

    // @Bean
    // AuthenticationManager authenticationManager() {
    //     DaoAuthenticationProvider provider = new DaoAuthenticationProvider(detailsService());
    //     return new ProviderManager(provider);
    // }

    @Bean
    UserDetailsService detailsService() {
        return username -> {
            return new User("Sai", "{noop}jt", List.of());
        };
    }
}
