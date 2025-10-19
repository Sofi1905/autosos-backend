package com.autosos.backend.service;

import com.autosos.backend.dto.JwtResponse;
import com.autosos.backend.dto.LoginRequest;
import com.autosos.backend.dto.UserRegistrationRequest;

public interface AuthService {
    JwtResponse register(UserRegistrationRequest request);
    JwtResponse login(LoginRequest request);
}
