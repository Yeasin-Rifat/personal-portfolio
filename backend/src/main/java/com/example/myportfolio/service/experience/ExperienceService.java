package com.example.myportfolio.service.experience;

import com.example.myportfolio.dto.experience.ExperienceRequestDTO;
import com.example.myportfolio.dto.experience.ExperienceResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExperienceService {

    ExperienceResponseDTO create(
            ExperienceRequestDTO dto
    );

    ExperienceResponseDTO getById(
            Long id
    );

    Page<ExperienceResponseDTO> getAll(
            Pageable pageable
    );

    ExperienceResponseDTO update(
            Long id,
            ExperienceRequestDTO dto
    );

    void delete(
            Long id
    );
}