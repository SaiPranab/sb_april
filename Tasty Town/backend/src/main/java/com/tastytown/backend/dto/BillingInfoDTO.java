package com.tastytown.backend.dto;

public record BillingInfoDTO(
    String fullName,
    String email,
    String phoneNumber,
    String address,
    String state,
    String city,
    String zip
) {
    
}
