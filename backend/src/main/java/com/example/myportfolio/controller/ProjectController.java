package com.example.myportfolio.controller;

import com.example.myportfolio.common.ApiResponse;
import com.example.myportfolio.dto.project.ProjectRequestDTO;
import com.example.myportfolio.dto.project.ProjectResponseDTO;
import com.example.myportfolio.project.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ApiResponse<ProjectResponseDTO> create(
            @Valid @RequestBody ProjectRequestDTO dto
    ) {

        return ApiResponse.<ProjectResponseDTO>builder()
                .success(true)
                .message("Project Created Successfully")
                .data(projectService.create(dto))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ProjectResponseDTO> getById(
            @PathVariable Long id
    ) {

        return ApiResponse.<ProjectResponseDTO>builder()
                .success(true)
                .message("Project Retrieved Successfully")
                .data(projectService.getProject(id))
                .build();
    }

    @GetMapping
    public ApiResponse<Page<ProjectResponseDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        return ApiResponse.<Page<ProjectResponseDTO>>builder()
                .success(true)
                .message("Projects Retrieved Successfully")
                .data(
                        projectService.getProjects(
                                PageRequest.of(page, size)
                        )
                )
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ProjectResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody ProjectRequestDTO dto
    ) {

        return ApiResponse.<ProjectResponseDTO>builder()
                .success(true)
                .message("Project Updated Successfully")
                .data(projectService.update(id, dto))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(
            @PathVariable Long id
    ) {

        projectService.delete(id);

        return ApiResponse
                .<String>builder()
                .success(true)
                .message("Skill Deleted Successfully")
                .build();
    }
}