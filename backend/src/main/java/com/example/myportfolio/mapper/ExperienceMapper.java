package com.example.myportfolio.mapper;


import com.example.myportfolio.dto.experience.ExperienceRequestDTO;
import com.example.myportfolio.dto.experience.ExperienceResponseDTO;
import com.example.myportfolio.entity.Experience;

public class ExperienceMapper {

    public static Experience toEntity(
            ExperienceRequestDTO dto
    ) {

        Experience experience =
                new Experience();

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

        return experience;
    }

    public static ExperienceResponseDTO toResponseDTO(
            Experience experience
    ) {

        return ExperienceResponseDTO.builder()
                .id(experience.getId())
                .companyName(
                        experience.getCompanyName()
                )
                .position(
                        experience.getPosition()
                )
                .startDate(
                        experience.getStartDate()
                )
                .endDate(
                        experience.getEndDate()
                )
                .currentlyWorking(
                        experience.getCurrentlyWorking()
                )
                .description(
                        experience.getDescription()
                )
                .build();
    }
}