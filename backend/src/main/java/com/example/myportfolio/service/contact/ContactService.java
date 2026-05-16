package com.example.myportfolio.service.contact;

import com.example.myportfolio.dto.contact.ContactRequestDTO;
import com.example.myportfolio.dto.contact.ContactResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {

    ContactResponseDTO create(
            ContactRequestDTO dto
    );

    ContactResponseDTO getById(
            Long id
    );

    Page<ContactResponseDTO> getAll(
            Pageable pageable
    );

    void delete(
            Long id
    );
}