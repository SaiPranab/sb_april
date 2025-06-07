package com.tastytown.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastytown.backend.entity.Food;

public interface FoodRepository extends JpaRepository<Food, String> {

}
