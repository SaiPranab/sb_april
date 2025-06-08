package com.tastytown.backend.mapper;

import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import com.tastytown.backend.entity.Category;
import com.tastytown.backend.entity.Food;

public class FoodMapper {
    private FoodMapper() {
    }

    public static Food convertToEntity(FoodRequestDTO requestDTO, 
                                Category existingCategory, String fileName) {
       return Food.builder()
                .foodName(requestDTO.foodName())
                .foodDescription(requestDTO.foodDescription())
                .foodPrice(requestDTO.foodPrice())
                .foodImage(fileName)
                .category(existingCategory)
                .build();

    }

    public static FoodResponseDTO convertToDTO(Food savedFood) {
        return new FoodResponseDTO(
                savedFood.getFoodId(),
                savedFood.getFoodName(),
                savedFood.getFoodDescription(),
                savedFood.getFoodPrice(),
                savedFood.getFoodImage(),
                savedFood.getCategory().getCategoryId(),
                savedFood.getCategory().getCategoryName());
    }
}
