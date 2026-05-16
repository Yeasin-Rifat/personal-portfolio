package com.example.myportfolio.service.auth;

import com.example.myportfolio.dto.login.LoginRequestDTO;
import com.example.myportfolio.dto.login.LoginResponseDTO;
import com.example.myportfolio.dto.register.RegisterRequestDTO;
import com.example.myportfolio.entity.Admin;
import com.example.myportfolio.exception.ResourceNotFoundException;
import com.example.myportfolio.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl
        implements AuthService {

    private final AdminRepository adminRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDTO login(
            LoginRequestDTO dto
    ) {

        Admin admin = adminRepository
                .findByEmail(dto.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Invalid Credentials"
                        )
                );

        boolean passwordMatched =
                passwordEncoder.matches(
                        dto.getPassword(),
                        admin.getPassword()
                );

        if (!passwordMatched) {

            throw new RuntimeException(
                    "Invalid Credentials"
            );
        }

        String token =
                jwtService.generateToken(
                        admin.getEmail()
                );

        return LoginResponseDTO.builder()
                .token(token)
                .build();
    }

    @Override
    public String register(
            RegisterRequestDTO dto
    ) {

        boolean exists =
                adminRepository.findByEmail(
                        dto.getEmail()
                ).isPresent();

        if (exists) {

            throw new RuntimeException(
                    "Email Already Exists"
            );
        }

        Admin admin = new Admin();

        admin.setEmail(dto.getEmail());

        admin.setPassword(
                passwordEncoder.encode(
                        dto.getPassword()
                )
        );

        adminRepository.save(admin);

        return "Admin Registered Successfully";
    }
}