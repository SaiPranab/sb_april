package com.tastytown.backend.service;

import org.springframework.web.bind.annotation.RequestAttribute;

import com.tastytown.backend.dto.CartItemRequestDTO;
import com.tastytown.backend.dto.CartResponseDTO;

public interface ICartService {
    CartResponseDTO addItemToCart(String userId, CartItemRequestDTO cartItemRequestDTO);

    CartResponseDTO getCartByUserId(String userId);

    CartResponseDTO updateItemQuantity(String userId, CartItemRequestDTO cartItemRequestDTO);

    CartResponseDTO removeItemFromCart(String userId, String foodId);

    void clearCartItems(String userId);
}
