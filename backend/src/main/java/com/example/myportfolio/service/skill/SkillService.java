package com.example.myportfolio.service.skill;

import com.example.myportfolio.dto.skill.SkillRequestDTO;
import com.example.myportfolio.dto.skill.SkillResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SkillService {

    SkillResponseDTO create(
            SkillRequestDTO dto
    );

    SkillResponseDTO getById(
            Long id
    );

    Page<SkillResponseDTO> getAll(
            Pageable pageable
    );

    SkillResponseDTO update(
            Long id,
            SkillRequestDTO dto
    );

    void delete(
            Long id
    );
}