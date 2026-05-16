package com.example.myportfolio.dto.profile;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileRequestDTO {

    @NotBlank(message = "Full name is required")
    private String fullName;

    private String title;

    private String bio;

    private String profileImage;

    private String resumeUrl;

    private String githubLink;

    private String linkedinLink;

    private String facebookLink;

    private String email;

    private String phone;

    private String location;
}