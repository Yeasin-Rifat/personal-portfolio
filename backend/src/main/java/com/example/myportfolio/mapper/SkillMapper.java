package com.example.myportfolio.mapper;


import com.example.myportfolio.dto.skill.SkillRequestDTO;
import com.example.myportfolio.dto.skill.SkillResponseDTO;
import com.example.myportfolio.entity.Skill;

public class SkillMapper {

    public static Skill toEntity(
            SkillRequestDTO dto
    ) {

        Skill skill = new Skill();

        skill.setName(dto.getName());
        skill.setPercentage(dto.getPercentage());
        skill.setIcon(dto.getIcon());
        skill.setCategory(dto.getCategory());

        return skill;
    }

    public static SkillResponseDTO toResponseDTO(
            Skill skill
    ) {

        return SkillResponseDTO.builder()
                .id(skill.getId())
                .name(skill.getName())
                .percentage(skill.getPercentage())
                .icon(skill.getIcon())
                .category(skill.getCategory())
                .build();
    }
}