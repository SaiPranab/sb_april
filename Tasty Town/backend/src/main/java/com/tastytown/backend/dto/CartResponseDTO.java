package com.tastytown.backend.dto;

import java.util.List;

public record CartResponseDTO(List<CartItemResponse> items) {
    
}
