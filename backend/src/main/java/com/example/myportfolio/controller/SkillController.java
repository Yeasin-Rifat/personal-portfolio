package com.example.myportfolio.controller;

import com.example.myportfolio.common.ApiResponse;
import com.example.myportfolio.dto.skill.SkillRequestDTO;
import com.example.myportfolio.dto.skill.SkillResponseDTO;
import com.example.myportfolio.service.skill.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SkillController {

    private final SkillService skillService;

    @PostMapping
    public ApiResponse<SkillResponseDTO> create(
            @Valid @RequestBody SkillRequestDTO dto
    ) {

        return ApiResponse
                .<SkillResponseDTO>builder()
                .success(true)
                .message("Skill Created Successfully")
                .data(skillService.create(dto))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<SkillResponseDTO> getById(
            @PathVariable Long id
    ) {

        return ApiResponse
                .<SkillResponseDTO>builder()
                .success(true)
                .message("Skill Retrieved Successfully")
                .data(skillService.getById(id))
                .build();
    }

    @GetMapping
    public ApiResponse<Page<SkillResponseDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        return ApiResponse
                .<Page<SkillResponseDTO>>builder()
                .success(true)
                .message("Skills Retrieved Successfully")
                .data(
                        skillService.getAll(
                                PageRequest.of(page, size)
                        )
                )
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<SkillResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody SkillRequestDTO dto
    ) {

        return ApiResponse
                .<SkillResponseDTO>builder()
                .success(true)
                .message("Skill Updated Successfully")
                .data(
                        skillService.update(id, dto)
                )
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(
            @PathVariable Long id
    ) {

        skillService.delete(id);

        return ApiResponse
                .<String>builder()
                .success(true)
                .message("Skill Deleted Successfully")
                .build();
    }
}