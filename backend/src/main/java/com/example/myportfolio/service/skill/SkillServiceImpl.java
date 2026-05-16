package com.example.myportfolio.service.skill;

import com.example.myportfolio.dto.skill.SkillRequestDTO;
import com.example.myportfolio.dto.skill.SkillResponseDTO;
import com.example.myportfolio.entity.Skill;
import com.example.myportfolio.exception.ResourceNotFoundException;
import com.example.myportfolio.mapper.SkillMapper;
import com.example.myportfolio.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl
        implements SkillService {

    private final SkillRepository skillRepository;

    @Override
    public SkillResponseDTO create(
            SkillRequestDTO dto
    ) {

        Skill skill =
                SkillMapper.toEntity(dto);

        return SkillMapper.toResponseDTO(
                skillRepository.save(skill)
        );
    }

    @Override
    public SkillResponseDTO getById(
            Long id
    ) {

        Skill skill =
                skillRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Skill Not Found"
                                )
                        );

        return SkillMapper.toResponseDTO(
                skill
        );
    }

    @Override
    public Page<SkillResponseDTO> getAll(
            Pageable pageable
    ) {

        return skillRepository.findAll(pageable)
                .map(SkillMapper::toResponseDTO);
    }

    @Override
    public SkillResponseDTO update(
            Long id,
            SkillRequestDTO dto
    ) {

        Skill skill =
                skillRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Skill Not Found"
                                )
                        );

        skill.setName(dto.getName());
        skill.setPercentage(dto.getPercentage());
        skill.setIcon(dto.getIcon());
        skill.setCategory(dto.getCategory());

        return SkillMapper.toResponseDTO(
                skillRepository.save(skill)
        );
    }

    @Override
    public void delete(
            Long id
    ) {

        Skill skill =
                skillRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Skill Not Found"
                                )
                        );

        skillRepository.delete(skill);
    }
}