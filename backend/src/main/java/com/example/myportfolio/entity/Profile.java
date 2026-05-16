package com.example.myportfolio.entity;

import com.example.myportfolio.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "profiles")
@Getter
@Setter
public class Profile extends BaseEntity {

    @Column(nullable = false)
    private String fullName;

    private String title;

    @Column(columnDefinition = "TEXT")
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