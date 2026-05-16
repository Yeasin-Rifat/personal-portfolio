package com.example.myportfolio.service.contact;

import com.example.myportfolio.dto.contact.ContactRequestDTO;
import com.example.myportfolio.dto.contact.ContactResponseDTO;
import com.example.myportfolio.entity.Contact;
import com.example.myportfolio.exception.ResourceNotFoundException;
import com.example.myportfolio.mapper.ContactMapper;
import com.example.myportfolio.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl
        implements ContactService {

    private final ContactRepository
            contactRepository;

    @Override
    public ContactResponseDTO create(
            ContactRequestDTO dto
    ) {

        Contact contact =
                ContactMapper.toEntity(dto);

        return ContactMapper.toResponseDTO(
                contactRepository.save(contact)
        );
    }

    @Override
    public ContactResponseDTO getById(
            Long id
    ) {

        Contact contact =
                contactRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Contact Not Found"
                                )
                        );

        return ContactMapper.toResponseDTO(
                contact
        );
    }

    @Override
    public Page<ContactResponseDTO> getAll(
            Pageable pageable
    ) {

        return contactRepository.findAll(pageable)
                .map(ContactMapper::toResponseDTO);
    }

    @Override
    public void delete(
            Long id
    ) {

        Contact contact =
                contactRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Contact Not Found"
                                )
                        );

        contactRepository.delete(contact);
    }
}