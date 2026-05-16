package com.example.myportfolio.mapper;


import com.example.myportfolio.dto.profile.ProfileRequestDTO;
import com.example.myportfolio.dto.profile.ProfileResponseDTO;
import com.example.myportfolio.entity.Profile;

public class ProfileMapper {

    public static Profile toEntity(
            ProfileRequestDTO dto
    ) {

        Profile profile = new Profile();

        profile.setFullName(dto.getFullName());
        profile.setTitle(dto.getTitle());
        profile.setBio(dto.getBio());
        profile.setProfileImage(dto.getProfileImage());
        profile.setResumeUrl(dto.getResumeUrl());
        profile.setGithubLink(dto.getGithubLink());
        profile.setLinkedinLink(dto.getLinkedinLink());
        profile.setFacebookLink(dto.getFacebookLink());
        profile.setEmail(dto.getEmail());
        profile.setPhone(dto.getPhone());
        profile.setLocation(dto.getLocation());

        return profile;
    }

    public static ProfileResponseDTO toResponseDTO(
            Profile profile
    ) {

        return ProfileResponseDTO.builder()
                .id(profile.getId())
                .fullName(profile.getFullName())
                .title(profile.getTitle())
                .bio(profile.getBio())
                .profileImage(profile.getProfileImage())
                .resumeUrl(profile.getResumeUrl())
                .githubLink(profile.getGithubLink())
                .linkedinLink(profile.getLinkedinLink())
                .facebookLink(profile.getFacebookLink())
                .email(profile.getEmail())
                .phone(profile.getPhone())
                .location(profile.getLocation())
                .build();
    }
}