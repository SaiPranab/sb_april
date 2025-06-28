package com.tastytown.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tastytown.backend.constants.OrderStatus;
import com.tastytown.backend.dto.BillingInfoDTO;
import com.tastytown.backend.dto.OrderDTO;
import com.tastytown.backend.service.IOrderServicde;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final IOrderServicde orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestAttribute String userId,
                                                @RequestBody BillingInfoDTO dto ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                            .body(orderService.placeOrder(dto, userId));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/user")
    public ResponseEntity<List<OrderDTO>> getOrdersByUser(@RequestAttribute String userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

    @PutMapping("/{orderCode}/status")
    public ResponseEntity<OrderDTO> updateOrderStatus(@PathVariable String orderCode, 
                                                        @RequestParam OrderStatus status )  {
        return ResponseEntity.ok(orderService.updateOrderStatus(orderCode, status));
    }
}

