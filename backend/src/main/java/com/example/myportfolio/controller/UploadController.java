package com.example.myportfolio.controller;

import com.example.myportfolio.dto.upload.ImageUploadResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private static final String UPLOAD_DIR =
            "uploads/";

    @PostMapping(
            consumes =
                    MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ImageUploadResponseDTO uploadImage(
            @RequestParam("file")
            MultipartFile file
    ) throws IOException {

        File directory =
                new File(UPLOAD_DIR);

        if (!directory.exists()) {

            directory.mkdirs();
        }

        String fileName =
                UUID.randomUUID()
                        + "_"
                        + file.getOriginalFilename();

        String filePath =
                UPLOAD_DIR + fileName;

        file.transferTo(
                new File(filePath)
        );

        String imageUrl =
                "http://localhost:8080/uploads/"
                        + fileName;

        return new ImageUploadResponseDTO(
                imageUrl
        );
    }
}