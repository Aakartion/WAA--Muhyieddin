package edu.miu.Lab4.service;

import edu.miu.springdemo.entity.dto.request.LoginRequest;
import edu.miu.springdemo.entity.dto.request.RefreshTokenRequest;
import edu.miu.springdemo.entity.dto.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
