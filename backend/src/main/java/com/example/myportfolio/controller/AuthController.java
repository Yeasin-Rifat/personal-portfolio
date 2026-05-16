package com.example.myportfolio.controller;

import com.example.myportfolio.common.ApiResponse;
import com.example.myportfolio.dto.login.LoginRequestDTO;
import com.example.myportfolio.dto.login.LoginResponseDTO;
import com.example.myportfolio.dto.register.RegisterRequestDTO;
import com.example.myportfolio.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<String> register(
            @Valid @RequestBody RegisterRequestDTO dto
    ) {

        return ApiResponse.<String>builder()
                .success(true)
                .message(
                        authService.register(dto)
                )
                .build();
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO dto
    ) {

        return ApiResponse
                .<LoginResponseDTO>builder()
                .success(true)
                .message("Login Successful")
                .data(authService.login(dto))
                .build();
    }
}