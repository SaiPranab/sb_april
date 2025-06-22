package com.tastytown.backend.service;

import com.tastytown.backend.dto.AuthRequest;
import com.tastytown.backend.dto.AuthResponse;
import com.tastytown.backend.entity.User;

public interface IAuthService {
    User register(AuthRequest request);

    AuthResponse login(AuthRequest request);
}
