package com.tastytown.backend.dto;

public record CartItemResponse(
        String foodId,
        int quantity,
        String foodName,
        String foodCategoryName,
        double foodPrice) {

}
