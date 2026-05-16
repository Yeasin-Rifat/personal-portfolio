package com.example.myportfolio.service.project;


import com.example.myportfolio.base.service.BaseServiceImpl;
import com.example.myportfolio.dto.project.ProjectRequestDTO;
import com.example.myportfolio.dto.project.ProjectResponseDTO;
import com.example.myportfolio.entity.Project;
import com.example.myportfolio.mapper.ProjectMapper;
import com.example.myportfolio.project.service.ProjectService;
import com.example.myportfolio.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl
        extends BaseServiceImpl<Project, Long>
        implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(
            ProjectRepository projectRepository
    ) {

        super(projectRepository);

        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectResponseDTO create(
            ProjectRequestDTO dto
    ) {

        Project project =
                ProjectMapper.toEntity(dto);

        return ProjectMapper.toResponseDto(
                projectRepository.save(project)
        );
    }

    @Override
    public ProjectResponseDTO getProject(
            Long id
    ) {

        return ProjectMapper.toResponseDto(
                getById(id)
        );
    }

    @Override
    public Page<ProjectResponseDTO> getProjects(
            Pageable pageable
    ) {

        return projectRepository.findAll(pageable)
                .map(ProjectMapper::toResponseDto);
    }

    @Override
    public ProjectResponseDTO update(
            Long id,
            ProjectRequestDTO dto
    ) {

        Project existingProject = getById(id);

        existingProject.setTitle(dto.getTitle());
        existingProject.setDescription(dto.getDescription());
        existingProject.setImageUrl(dto.getImageUrl());
        existingProject.setGithubLink(dto.getGithubLink());
        existingProject.setLiveLink(dto.getLiveLink());
        existingProject.setTechStack(dto.getTechStack());
        existingProject.setFeatured(dto.getFeatured());

        Project updatedProject =
                projectRepository.save(existingProject);

        return ProjectMapper.toResponseDto(
                updatedProject
        );
    }
}