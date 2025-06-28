package com.tastytown.backend.dto;

public record OrderItemDTO(
    String foodName,
    double foodPrice,
    int quantity
) {

}
