package com.tastytown.backend.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
@Tag(name = "Food API", 
        description = "This controller manages CRUD operations for Food Entity")

public class FoodController {
    private final IFoodService foodService;
    private final ObjectMapper objectMapper;

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Food Created")
    @Operation(summary = "Create a new Food")
    public ResponseEntity<FoodResponseDTO> saveFood(@RequestPart String rawJson, 
                                @RequestPart MultipartFile foodImage) throws IOException{
    
        FoodRequestDTO requestDTO = objectMapper.readValue(rawJson, FoodRequestDTO.class);

        return new ResponseEntity<>(foodService.createFood(requestDTO, foodImage), HttpStatus.CREATED);
    }
}
