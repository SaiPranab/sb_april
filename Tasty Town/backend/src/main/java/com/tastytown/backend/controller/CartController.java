package com.tastytown.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastytown.backend.dto.CartItemRequestDTO;
import com.tastytown.backend.dto.CartResponseDTO;
import com.tastytown.backend.service.ICartService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final ICartService cartService;

    @PostMapping
    public ResponseEntity<CartResponseDTO> addItemToCart(@RequestAttribute String userId,
                                                        @RequestBody CartItemRequestDTO dto){
        // return new ResponseEntity<>(cartService.addItemToCart(userId, dto), HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addItemToCart(userId, dto));
    }

    @GetMapping
    public ResponseEntity<CartResponseDTO> getCartByUserId(@RequestAttribute String userId) {
        return ResponseEntity.ok(cartService.getCartByUserId(userId));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> clearCartItemsOfAnUser(@RequestAttribute String userId) {
        cartService.clearCartItems(userId);
        return ResponseEntity.noContent().build();
    }
}
