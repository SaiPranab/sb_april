package com.tastytown.backend.dto;

public record FoodRequestDTO(
    String foodName,
    String foodDescription,
    double foodPrice,
    String categoryId
) {
    
}
