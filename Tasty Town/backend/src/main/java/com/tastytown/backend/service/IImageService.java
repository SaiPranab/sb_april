package com.tastytown.backend.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

public interface IImageService {
    byte[] extractFoodImage(String foodImageName) throws IOException;
}
