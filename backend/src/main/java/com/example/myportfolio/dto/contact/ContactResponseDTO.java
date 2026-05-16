package com.example.myportfolio.dto.contact;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContactResponseDTO {

    private Long id;

    private String name;

    private String email;

    private String subject;

    private String message;
}