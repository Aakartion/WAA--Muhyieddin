package edu.miu.Lab4.controller;

import edu.miu.Lab4.domain.dto.request.LoginRequest;
import edu.miu.Lab4.domain.dto.request.RefreshTokenRequest;
import edu.miu.Lab4.domain.dto.response.LoginResponse;
import edu.miu.Lab4.domain.dto.response.RefreshTokenResponse;
import edu.miu.Lab4.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest request) {
        return service.login(request);
    }

    @PostMapping("/refreshToken")
    public RefreshTokenResponse refreshToken(@RequestBody RefreshTokenRequest request) {
        return service.refreshToken(request);
    }

}