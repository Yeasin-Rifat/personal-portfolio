package com.example.myportfolio.service.profile;

import com.example.myportfolio.dto.profile.ProfileRequestDTO;
import com.example.myportfolio.dto.profile.ProfileResponseDTO;

public interface ProfileService {

    ProfileResponseDTO create(
            ProfileRequestDTO dto
    );

    ProfileResponseDTO getProfile();

    ProfileResponseDTO update(
            Long id,
            ProfileRequestDTO dto
    );
}