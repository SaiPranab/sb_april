package com.tastytown.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tastytown.backend.dto.CategoryRequestDTO;
import com.tastytown.backend.entity.Category;
import com.tastytown.backend.exception.CategoryNotFoundException;
import com.tastytown.backend.repository.CategoryRepository;
import com.tastytown.backend.service.ICategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService{
    private final CategoryRepository categoryRepository;

    public Category saveCategory(CategoryRequestDTO requestDTO) {
        var category = Category.builder()
                .categoryName(requestDTO.getCategoryName())
                .build();

        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(String categoryId) {
        return categoryRepository.findById(categoryId)
            .orElseThrow(() -> new CategoryNotFoundException("Category Not Found With ID:- " + categoryId));
    }

    public Category updateCategoryById(String categoryId, CategoryRequestDTO requestDTO) {
       var existingCategory = getCategoryById(categoryId);
       existingCategory.setCategoryName(requestDTO.getCategoryName());

       return categoryRepository.save(existingCategory);
    }

    public void deleteCategoryById(String categoryId) {
        getCategoryById(categoryId);
      categoryRepository.deleteById(categoryId);
    }


}
