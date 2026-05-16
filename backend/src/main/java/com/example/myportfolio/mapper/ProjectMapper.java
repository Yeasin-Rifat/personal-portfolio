package com.example.myportfolio.mapper;

import com.example.myportfolio.dto.project.ProjectRequestDTO;
import com.example.myportfolio.dto.project.ProjectResponseDTO;
import com.example.myportfolio.entity.Project;

public class ProjectMapper {

    public static Project toEntity(
            ProjectRequestDTO dto
    ) {

        Project project = new Project();

        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setImageUrl(dto.getImageUrl());
        project.setGithubLink(dto.getGithubLink());
        project.setLiveLink(dto.getLiveLink());
        project.setTechStack(dto.getTechStack());
        project.setFeatured(dto.getFeatured());

        return project;
    }

    public static ProjectResponseDTO toResponseDto(
            Project project
    ) {

        return ProjectResponseDTO.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .imageUrl(project.getImageUrl())
                .githubLink(project.getGithubLink())
                .liveLink(project.getLiveLink())
                .techStack(project.getTechStack())
                .featured(project.getFeatured())
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .build();
    }
}