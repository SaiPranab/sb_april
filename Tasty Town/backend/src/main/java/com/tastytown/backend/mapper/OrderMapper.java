package com.tastytown.backend.mapper;

import java.util.List;

import com.tastytown.backend.dto.OrderDTO;
import com.tastytown.backend.dto.OrderItemDTO;
import com.tastytown.backend.entity.Order;

public class OrderMapper {
    private OrderMapper() {}
    
    public static OrderDTO convertToOrderDTO(Order order) {
        List<OrderItemDTO> items = order.getOrderItems().stream()
            .map(orderItem -> 
                new OrderItemDTO(orderItem.getFoodName(), orderItem.getFoodPrice(), orderItem.getQuantity()))
            .toList();       

        return new OrderDTO(
            order.getOrderCode(),
            items,
            order.getTotalAmount(),
            order.getOrderStatus().toString(),
            order.getOrderDateTime(),
            order.getContactInfo(),
            order.getAddressInfo());
    }
}
