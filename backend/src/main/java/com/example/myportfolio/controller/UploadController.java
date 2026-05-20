package com.example.myportfolio.controller;

import com.example.myportfolio.dto.upload.ImageUploadResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private static final String UPLOAD_DIR =
            "G:/WorkPlace/my-portfolio/uploads/";

    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ImageUploadResponseDTO uploadImage(
            @RequestParam("file")
            MultipartFile file
    ) throws IOException {

        String fileName =
                UUID.randomUUID()
                        + "_"
                        + file.getOriginalFilename();

        Files.copy(
                file.getInputStream(),
                Paths.get(
                        UPLOAD_DIR + fileName
                ),
                StandardCopyOption.REPLACE_EXISTING
        );

        String imageUrl =
                "http://localhost:8080/uploads/"
                        + fileName;

        return new ImageUploadResponseDTO(
                imageUrl
        );
    }
}