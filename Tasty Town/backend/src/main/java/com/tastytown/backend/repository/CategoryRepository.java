package com.tastytown.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastytown.backend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
