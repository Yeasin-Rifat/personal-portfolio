package com.example.myportfolio.dto.skill;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SkillResponseDTO {

    private Long id;

    private String name;

    private Integer percentage;

    private String icon;

    private String category;
}