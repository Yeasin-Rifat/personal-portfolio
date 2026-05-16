package com.example.myportfolio.service.auth;


import com.example.myportfolio.dto.login.LoginRequestDTO;
import com.example.myportfolio.dto.login.LoginResponseDTO;
import com.example.myportfolio.dto.register.RegisterRequestDTO;

public interface AuthService {

    LoginResponseDTO login(
            LoginRequestDTO dto
    );

    String register(
            RegisterRequestDTO dto
    );
}