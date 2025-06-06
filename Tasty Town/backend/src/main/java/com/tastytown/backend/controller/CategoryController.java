package com.tastytown.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tastytown.backend.dto.CategoryRequestDTO;
import com.tastytown.backend.entity.Category;
import com.tastytown.backend.service.ICategoryService;
import com.tastytown.backend.service.impl.CategoryServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Tag(name = "Category API", description = "This controller manages CRUD operations for Category Entity")
public class CategoryController {
    private final ICategoryService categoryService;

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Category Created")
    @Operation(summary = "Create a new Category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequestDTO requestDTO) {
        return new ResponseEntity<>(categoryService.saveCategory(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiResponse(description = "Get All Categories")
    @Operation(summary = "Extract all categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{categoryId}")
    @ApiResponse(description = "Get a category by catgeory id")
    @Operation(summary = "Extract a category by category id")
    public ResponseEntity<Category> getCategoryById(@PathVariable String categoryId) {
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @PutMapping("/{categoryId}")
    @ApiResponse(description = "Update a category by catgeory id")
    @Operation(summary = "Update a category by category id")
    public ResponseEntity<Category> updateCategory(@PathVariable String categoryId,
            @RequestBody CategoryRequestDTO requestDTO) {
        return ResponseEntity.ok(categoryService.updateCategoryById(categoryId, requestDTO));
    }

    @DeleteMapping("/{categoryId}")
    @ApiResponse(responseCode = "204", description = "Delete a category by catgeory id")
    @Operation(summary = "Delete a category by category id")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable String categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return ResponseEntity.noContent().build();
    }
}
