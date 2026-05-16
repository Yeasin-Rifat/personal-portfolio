package com.example.myportfolio.config;

import com.example.myportfolio.entity.Admin;
import com.example.myportfolio.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminSeeder implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (adminRepository.findByEmail("admin@gmail.com").isEmpty()) {

            Admin admin = new Admin();
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("admin"));

            adminRepository.save(admin);

            System.out.println("✅ Admin Created");
        }
    }
}