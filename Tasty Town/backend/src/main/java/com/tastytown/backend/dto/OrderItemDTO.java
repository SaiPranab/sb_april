package com.tastytown.backend.dto;

public record OrderItemDTO(
    String foodName,
    String foodPrice,
    int quantity
) {

}
