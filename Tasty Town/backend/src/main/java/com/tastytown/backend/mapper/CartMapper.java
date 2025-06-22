package com.tastytown.backend.mapper;

import com.tastytown.backend.dto.CartResponseDTO;
import com.tastytown.backend.entity.Cart;

import java.util.List;

import com.tastytown.backend.dto.CartItemResponse;;

public class CartMapper {
    private CartMapper() {}

    public static CartResponseDTO convertToCartResponseDTO(Cart cart) {
        List<CartItemResponse> items = cart.getItems().stream()
            .map(item -> 
                    new CartItemResponse(item.getFood().getFoodId(),
                        item.getQuantity(),
                        item.getFood().getFoodName(),
                        item.getFood().getCategory().getCategoryName(),
                        item.getFood().getFoodPrice())
            ).toList();

        return new CartResponseDTO(items);
    }
}
