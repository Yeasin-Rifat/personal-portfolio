package com.example.myportfolio.dto.project;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ProjectResponseDTO {

    private Long id;

    private String title;

    private String description;

    private String imageUrl;

    private String githubLink;

    private String liveLink;

    private String techStack;

    private Boolean featured;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}