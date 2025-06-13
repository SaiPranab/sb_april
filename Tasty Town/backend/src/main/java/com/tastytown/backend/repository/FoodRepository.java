package com.tastytown.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tastytown.backend.entity.Food;

public interface FoodRepository extends JpaRepository<Food, String> {
    Page<Food> findByCategory_CategoryIdAndFoodNameContainingIgnoreCase
                (String categoryId, String foodName, Pageable pageable);

    Page<Food> findByFoodNameContainingIgnoreCase(String search, Pageable pageable);

    Page<Food> findByCategory_CategoryId(String categoryId, Pageable pageable);
}
