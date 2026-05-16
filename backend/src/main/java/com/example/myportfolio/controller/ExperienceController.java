package com.example.myportfolio.controller;


import com.example.myportfolio.common.ApiResponse;
import com.example.myportfolio.dto.experience.ExperienceRequestDTO;
import com.example.myportfolio.dto.experience.ExperienceResponseDTO;
import com.example.myportfolio.service.experience.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExperienceController {

    private final ExperienceService
            experienceService;

    @PostMapping
    public ApiResponse<ExperienceResponseDTO>
    create(
            @Valid
            @RequestBody
            ExperienceRequestDTO dto
    ) {

        return ApiResponse
                .<ExperienceResponseDTO>builder()
                .success(true)
                .message(
                        "Experience Created Successfully"
                )
                .data(
                        experienceService.create(dto)
                )
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ExperienceResponseDTO>
    getById(
            @PathVariable Long id
    ) {

        return ApiResponse
                .<ExperienceResponseDTO>builder()
                .success(true)
                .message(
                        "Experience Retrieved Successfully"
                )
                .data(
                        experienceService.getById(id)
                )
                .build();
    }

    @GetMapping
    public ApiResponse<Page<ExperienceResponseDTO>>
    getAll(
            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size
    ) {

        return ApiResponse
                .<Page<ExperienceResponseDTO>>builder()
                .success(true)
                .message(
                        "Experiences Retrieved Successfully"
                )
                .data(
                        experienceService.getAll(
                                PageRequest.of(page, size)
                        )
                )
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ExperienceResponseDTO>
    update(
            @PathVariable Long id,

            @Valid
            @RequestBody
            ExperienceRequestDTO dto
    ) {

        return ApiResponse
                .<ExperienceResponseDTO>builder()
                .success(true)
                .message(
                        "Experience Updated Successfully"
                )
                .data(
                        experienceService.update(id, dto)
                )
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(
            @PathVariable Long id
    ) {

        experienceService.delete(id);

        return ApiResponse
                .<String>builder()
                .success(true)
                .message(
                        "Experience Deleted Successfully"
                )
                .build();
    }
}