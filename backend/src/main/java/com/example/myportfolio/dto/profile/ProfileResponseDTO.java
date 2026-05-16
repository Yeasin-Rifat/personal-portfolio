package com.example.myportfolio.dto.profile;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProfileResponseDTO {

    private Long id;

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