package com.example.myportfolio.controller;

import com.example.myportfolio.common.ApiResponse;
import com.example.myportfolio.dto.profile.ProfileRequestDTO;
import com.example.myportfolio.dto.profile.ProfileResponseDTO;
import com.example.myportfolio.service.profile.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public ApiResponse<ProfileResponseDTO> create(
            @Valid @RequestBody ProfileRequestDTO dto
    ) {

        return ApiResponse
                .<ProfileResponseDTO>builder()
                .success(true)
                .message("Profile Created Successfully")
                .data(profileService.create(dto))
                .build();
    }

    @GetMapping
    public ApiResponse<ProfileResponseDTO> getProfile() {

        return ApiResponse
                .<ProfileResponseDTO>builder()
                .success(true)
                .message("Profile Retrieved Successfully")
                .data(profileService.getProfile())
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ProfileResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody ProfileRequestDTO dto
    ) {

        return ApiResponse
                .<ProfileResponseDTO>builder()
                .success(true)
                .message("Profile Updated Successfully")
                .data(profileService.update(id, dto))
                .build();
    }
}