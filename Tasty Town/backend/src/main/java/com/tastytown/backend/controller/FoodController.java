package com.tastytown.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import com.tastytown.backend.service.IFoodService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/foods")
@RequiredArgsConstructor
@Tag(name = "Food API", description = "This controller manages CRUD operations for Food Entity")

public class FoodController {
    private final IFoodService foodService;
    private final ObjectMapper objectMapper;

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Food Created")
    @Operation(summary = "Create a new Food")
    public ResponseEntity<FoodResponseDTO> saveFood(@RequestPart String rawJson,
            @RequestPart MultipartFile foodImage) throws IOException {

        FoodRequestDTO requestDTO = objectMapper.readValue(rawJson, FoodRequestDTO.class);

        return new ResponseEntity<>(foodService.createFood(requestDTO, foodImage), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiResponse(responseCode = "200", description = "All food Extracted succesfully.")
    @Operation(summary = "Extract all foods")
    public ResponseEntity<List<FoodResponseDTO>> getAllFoods() {
        return ResponseEntity.ok(foodService.getAllFoods());
    }

    @GetMapping("/{foodId}")
    @ApiResponse(responseCode = "200", description = "A food Extracted succesfully By id.")
    @Operation(summary = "Extract a food By Id")
    public ResponseEntity<FoodResponseDTO> getFoodById(@PathVariable String foodId) {
        return ResponseEntity.ok(foodService.getFoodById(foodId));
    }

    @GetMapping("/paginated-foods")
    public ResponseEntity<Page<FoodResponseDTO>> getPaginatedFoods(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "8") int pageSize,
            @RequestParam(required = false, defaultValue = "all") String categoryId,
            @RequestParam(required = false, defaultValue = "all") String search) {
        return ResponseEntity.ok(foodService.getPaginatedFoods(pageNumber, pageSize, categoryId, search));
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<FoodResponseDTO> deleteFoodById(@PathVariable String foodId)
            throws IOException {
        return new ResponseEntity<>(foodService.deleteFoodById(foodId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{foodId}")
    public ResponseEntity<FoodResponseDTO> updateFood(
                    @PathVariable String foodId,
                    @RequestPart String rawJson,
                    @RequestPart(required = false) MultipartFile foodImage) throws IOException{

        FoodRequestDTO dto = objectMapper.readValue(rawJson, FoodRequestDTO.class);
        return ResponseEntity.ok(foodService.updateFoodById(foodId, dto, foodImage));                
    }
}
