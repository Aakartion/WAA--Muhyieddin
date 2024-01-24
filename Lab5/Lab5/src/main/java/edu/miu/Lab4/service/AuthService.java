package edu.miu.Lab4.service;

import edu.miu.Lab4.domain.dto.request.LoginRequest;
import edu.miu.Lab4.domain.dto.request.RefreshTokenRequest;
import edu.miu.Lab4.domain.dto.response.LoginResponse;
import edu.miu.Lab4.domain.dto.response.RefreshTokenResponse;
import org.springframework.stereotype.Service;

public interface AuthService {
    LoginResponse login(LoginRequest request);
    RefreshTokenResponse refreshToken(RefreshTokenRequest request);
}
