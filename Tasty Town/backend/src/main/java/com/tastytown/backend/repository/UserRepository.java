package com.tastytown.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastytown.backend.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
    Optional<User> findByUserEmail(String email);
}
