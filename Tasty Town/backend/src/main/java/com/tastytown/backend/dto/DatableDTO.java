package com.tastytown.backend.dto;

import java.util.List;

public record DatableDTO(
    int pageNumber,
    int pageSize,
    List<FoodResponseDTO> dtos
) {
    
}
