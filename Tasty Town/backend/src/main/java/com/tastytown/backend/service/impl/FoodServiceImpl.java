package com.tastytown.backend.service.impl;

import org.springframework.stereotype.Service;

import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import com.tastytown.backend.entity.Food;
import com.tastytown.backend.mapper.FoodMapper;
import com.tastytown.backend.repository.CategoryRepository;
import com.tastytown.backend.repository.FoodRepository;
import com.tastytown.backend.service.ICategoryService;
import com.tastytown.backend.service.IFoodService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements IFoodService {
    private final ICategoryService categoryService;
    private final CategoryRepository categoryRepository;
    private final FoodRepository foodRepository;

    @Override
    public FoodResponseDTO createFood(FoodRequestDTO requestDTO) {
        var existingCategory = categoryService.getCategoryById(requestDTO.categoryId());

        var food = FoodMapper.convertToEntity(requestDTO, existingCategory);
        
        var savedFood = foodRepository.save(food);

        return FoodMapper.convertToDTO(savedFood);
    }

}
