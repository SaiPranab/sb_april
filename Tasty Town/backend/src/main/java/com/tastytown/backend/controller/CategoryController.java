package com.tastytown.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastytown.backend.dto.CategoryRequestDTO;
import com.tastytown.backend.entity.Category;
import com.tastytown.backend.srevice.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequestDTO requestDTO) {
        // return categoryService.saveCategory(requestDTO);

        // var savedCategory = categoryService.saveCategory(requestDTO);
        // return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);

        return new ResponseEntity<>(categoryService.saveCategory(requestDTO), HttpStatus.CREATED);
    }
}
