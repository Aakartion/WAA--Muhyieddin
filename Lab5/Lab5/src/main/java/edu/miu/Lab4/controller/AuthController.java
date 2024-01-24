//package edu.miu.Lab4.controller;
//
//import edu.miu.Lab4.service.AuthService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/authenticate")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class AuthController {
//
//    private final AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//        var loginResponse = authService.login(loginRequest);
//        return new ResponseEntity<LoginResponse>(
//                loginResponse, HttpStatus.OK);
//    }
//
//    @PostMapping("/refreshToken")
//    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
//        return authService.refreshToken(refreshTokenRequest);
//    }
//
//}
