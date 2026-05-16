package com.example.myportfolio.dto.project;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private String imageUrl;

    private String githubLink;

    private String liveLink;

    private String techStack;

    private Boolean featured;
}