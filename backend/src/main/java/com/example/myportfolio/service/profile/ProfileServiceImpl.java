package com.example.myportfolio.service.profile;

import com.example.myportfolio.dto.profile.ProfileRequestDTO;
import com.example.myportfolio.dto.profile.ProfileResponseDTO;
import com.example.myportfolio.entity.Profile;
import com.example.myportfolio.exception.ResourceNotFoundException;
import com.example.myportfolio.mapper.ProfileMapper;
import com.example.myportfolio.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl
        implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public ProfileResponseDTO create(
            ProfileRequestDTO dto
    ) {

        Profile profile =
                ProfileMapper.toEntity(dto);

        return ProfileMapper.toResponseDTO(
                profileRepository.save(profile)
        );
    }

    @Override
    public ProfileResponseDTO getProfile() {

        Profile profile =
                profileRepository.findAll()
                        .stream()
                        .findFirst()
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Profile Not Found"
                                )
                        );

        return ProfileMapper.toResponseDTO(
                profile
        );
    }

    @Override
    public ProfileResponseDTO update(
            Long id,
            ProfileRequestDTO dto
    ) {

        Profile profile =
                profileRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Profile Not Found"
                                )
                        );

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

        return ProfileMapper.toResponseDTO(
                profileRepository.save(profile)
        );
    }
}