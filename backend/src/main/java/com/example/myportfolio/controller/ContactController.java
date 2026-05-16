package com.example.myportfolio.controller;


import com.example.myportfolio.common.ApiResponse;
import com.example.myportfolio.dto.contact.ContactRequestDTO;
import com.example.myportfolio.dto.contact.ContactResponseDTO;
import com.example.myportfolio.service.contact.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public ApiResponse<ContactResponseDTO>
    create(
            @Valid
            @RequestBody
            ContactRequestDTO dto
    ) {

        return ApiResponse
                .<ContactResponseDTO>builder()
                .success(true)
                .message(
                        "Message Sent Successfully"
                )
                .data(
                        contactService.create(dto)
                )
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ContactResponseDTO>
    getById(
            @PathVariable Long id
    ) {

        return ApiResponse
                .<ContactResponseDTO>builder()
                .success(true)
                .message(
                        "Contact Retrieved Successfully"
                )
                .data(
                        contactService.getById(id)
                )
                .build();
    }

    @GetMapping
    public ApiResponse<Page<ContactResponseDTO>>
    getAll(
            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size
    ) {

        return ApiResponse
                .<Page<ContactResponseDTO>>builder()
                .success(true)
                .message(
                        "Contacts Retrieved Successfully"
                )
                .data(
                        contactService.getAll(
                                PageRequest.of(page, size)
                        )
                )
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(
            @PathVariable Long id
    ) {

        contactService.delete(id);

        return ApiResponse
                .<String>builder()
                .success(true)
                .message(
                        "Contact Deleted Successfully"
                )
                .build();
    }
}