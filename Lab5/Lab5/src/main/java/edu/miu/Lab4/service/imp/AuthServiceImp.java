package edu.miu.Lab4.service.imp;

import edu.miu.Lab4.domain.User;
import edu.miu.Lab4.domain.dto.request.LoginRequest;
import edu.miu.Lab4.domain.dto.request.RefreshTokenRequest;
import edu.miu.Lab4.domain.dto.response.LoginResponse;
import edu.miu.Lab4.domain.dto.response.RefreshTokenResponse;
import edu.miu.Lab4.repository.UserRepository;
import edu.miu.Lab4.service.AuthService;
import edu.miu.Lab4.utility.JwtUtil;
import edu.miu.Lab4.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;


    @Override
    public RefreshTokenResponse refreshToken(RefreshTokenRequest request) {
        if (!jwtUtil.validate(request.getRefreshToken()))
            throw new RuntimeException("Invalid Refresh Token");

        String username = jwtUtil.getUsername(request.getRefreshToken());
        User principal = userRepository.findByName(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username does not exist"));
        String accessToken = jwtUtil.generateAccessToken(principal.getName(), principal.getRoles().stream().map(Role::getName).collect(Collectors.toList()).toString());
        return new RefreshTokenResponse(accessToken);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        User principal = (User) authentication.getPrincipal();
        String accessToken = jwtUtil.generateAccessToken(principal.getName(), principal.getRoles().stream().map(Role::getName).collect(Collectors.toList()).toString());
        String refreshToken = jwtUtil.generateRefreshToken(principal.getName());
        return new LoginResponse(accessToken, refreshToken);
    }
}
