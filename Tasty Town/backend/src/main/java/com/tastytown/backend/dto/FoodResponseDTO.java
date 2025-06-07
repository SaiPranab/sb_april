package com.tastytown.backend.dto;

public record FoodResponseDTO(
        String foodId,
        String foodName,
        String foodDescription,
        double foodPrice,
        String foodImage,
        String categoryId,
        String categoryName) {

}
