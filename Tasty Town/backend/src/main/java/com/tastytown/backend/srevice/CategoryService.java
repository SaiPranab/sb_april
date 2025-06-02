package com.tastytown.backend.srevice;

import org.springframework.stereotype.Service;

import com.tastytown.backend.dto.CategoryRequestDTO;
import com.tastytown.backend.entity.Category;
import com.tastytown.backend.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category saveCategory(CategoryRequestDTO requestDTO) {
        var category = Category.builder()
                .categoryName(requestDTO.getCategoryName())
                .build();

        return categoryRepository.save(category);
    }
}
