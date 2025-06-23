package com.tastytown.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastytown.backend.entity.Cart;
import com.tastytown.backend.entity.User;

public interface CartRepository extends JpaRepository<Cart, String> {
    Optional<Cart> findByUser(User user);

    void deleteByUser(User user);
}
