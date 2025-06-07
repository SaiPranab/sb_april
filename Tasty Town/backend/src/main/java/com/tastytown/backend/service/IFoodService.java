package com.tastytown.backend.service;

import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;

public interface IFoodService {
    FoodResponseDTO createFood(FoodRequestDTO requestDTO);
}
