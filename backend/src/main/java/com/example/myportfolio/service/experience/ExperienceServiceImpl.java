package com.example.myportfolio.service.experience;

import com.example.myportfolio.dto.experience.ExperienceRequestDTO;
import com.example.myportfolio.dto.experience.ExperienceResponseDTO;
import com.example.myportfolio.entity.Experience;
import com.example.myportfolio.exception.ResourceNotFoundException;
import com.example.myportfolio.mapper.ExperienceMapper;
import com.example.myportfolio.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl
        implements ExperienceService {

    private final ExperienceRepository
            experienceRepository;

    @Override
    public ExperienceResponseDTO create(
            ExperienceRequestDTO dto
    ) {

        Experience experience =
                ExperienceMapper.toEntity(dto);

        return ExperienceMapper.toResponseDTO(
                experienceRepository.save(experience)
        );
    }

    @Override
    public ExperienceResponseDTO getById(
            Long id
    ) {

        Experience experience =
                experienceRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Experience Not Found"
                                )
                        );

        return ExperienceMapper.toResponseDTO(
                experience
        );
    }

    @Override
    public Page<ExperienceResponseDTO> getAll(
            Pageable pageable
    ) {

        return experienceRepository.findAll(pageable)
                .map(
                        ExperienceMapper::toResponseDTO
                );
    }

    @Override
    public ExperienceResponseDTO update(
            Long id,
            ExperienceRequestDTO dto
    ) {

        Experience experience =
                experienceRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Experience Not Found"
                                )
                        );

        experience.setCompanyName(
                dto.getCompanyName()
        );

        experience.setPosition(
                dto.getPosition()
        );

        experience.setStartDate(
                dto.getStartDate()
        );

        experience.setEndDate(
                dto.getEndDate()
        );

        experience.setCurrentlyWorking(
                dto.getCurrentlyWorking()
        );

        experience.setDescription(
                dto.getDescription()
        );

        return ExperienceMapper.toResponseDTO(
                experienceRepository.save(experience)
        );
    }

    @Override
    public void delete(
            Long id
    ) {

        Experience experience =
                experienceRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Experience Not Found"
                                )
                        );

        experienceRepository.delete(
                experience
        );
    }
}