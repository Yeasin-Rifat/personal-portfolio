package com.example.myportfolio.project.service;


import com.example.myportfolio.base.service.BaseService;
import com.example.myportfolio.dto.project.ProjectRequestDTO;
import com.example.myportfolio.dto.project.ProjectResponseDTO;
import com.example.myportfolio.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService
        extends BaseService<Project, Long> {

    ProjectResponseDTO create(
            ProjectRequestDTO dto
    );

    ProjectResponseDTO getProject(Long id);

    Page<ProjectResponseDTO> getProjects(
            Pageable pageable
    );

    ProjectResponseDTO update(
            Long id,
            ProjectRequestDTO dto
    );
}