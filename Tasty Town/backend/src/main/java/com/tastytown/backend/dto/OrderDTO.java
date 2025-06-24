package com.tastytown.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(
    String orderCode,
    List<OrderItemDTO>  orderItems,
    double totalAmount,
    String orderStatus,
    LocalDateTime orderDateTime,
    String contactInfo,
    String addressInfo
) {
    
}
