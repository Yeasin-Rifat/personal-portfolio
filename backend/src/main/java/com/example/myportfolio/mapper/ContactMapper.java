package com.example.myportfolio.mapper;


import com.example.myportfolio.dto.contact.ContactRequestDTO;
import com.example.myportfolio.dto.contact.ContactResponseDTO;
import com.example.myportfolio.entity.Contact;

public class ContactMapper {

    public static Contact toEntity(
            ContactRequestDTO dto
    ) {

        Contact contact = new Contact();

        contact.setName(dto.getName());
        contact.setEmail(dto.getEmail());
        contact.setSubject(dto.getSubject());
        contact.setMessage(dto.getMessage());

        return contact;
    }

    public static ContactResponseDTO toResponseDTO(
            Contact contact
    ) {

        return ContactResponseDTO.builder()
                .id(contact.getId())
                .name(contact.getName())
                .email(contact.getEmail())
                .subject(contact.getSubject())
                .message(contact.getMessage())
                .build();
    }
}