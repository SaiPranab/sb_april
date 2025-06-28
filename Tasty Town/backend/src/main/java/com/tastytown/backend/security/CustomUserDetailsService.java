package com.tastytown.backend.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tastytown.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = repository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists with email:- " + email));

        return new User(
            user.getUserEmail(),
            user.getUserPassword(),
            List.of(new SimpleGrantedAuthority(user.getRole().toString()))
        );
    }
    
}
