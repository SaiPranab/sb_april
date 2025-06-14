package com.tastytown.backend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;

public interface IFoodService {
    FoodResponseDTO createFood(FoodRequestDTO requestDTO, MultipartFile file) throws IOException;

    List<FoodResponseDTO> getAllFoods();

    FoodResponseDTO getFoodById(String foodId);

    Page<FoodResponseDTO> getPaginatedFoods(int pageNumber, int pageSize, 
                                                        String categoryId, String search);

    FoodResponseDTO deleteFoodById(String foodId) throws IOException;

    FoodResponseDTO updateFoodById(String foodId, FoodRequestDTO dto, MultipartFile foodImage) 
                                                                        throws IOException;
}
