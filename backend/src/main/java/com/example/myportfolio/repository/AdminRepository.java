package com.example.myportfolio.repository;

import com.example.myportfolio.base.repository.BaseRepository;
import com.example.myportfolio.entity.Admin;
import java.util.Optional;

public interface AdminRepository
        extends BaseRepository<Admin, Long> {

    Optional<Admin> findByEmail(String email);
}