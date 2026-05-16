package com.example.myportfolio.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T, ID> {

    T create(T entity);

//    T update(ID id, T entity);

    T getById(ID id);

    Page<T> getAll(Pageable pageable);

    void delete(ID id);
}