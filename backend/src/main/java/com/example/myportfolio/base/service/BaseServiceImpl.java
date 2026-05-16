package com.example.myportfolio.base.service;

import com.example.myportfolio.base.repository.BaseRepository;
import com.example.myportfolio.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public abstract class BaseServiceImpl<T, ID>
        implements BaseService<T, ID> {

    protected final BaseRepository<T, ID> repository;

    @Override
    public T create(T entity) {

        return repository.save(entity);
    }

    @Override
    public T getById(ID id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Data not found with id : " + id
                        )
                );
    }

    @Override
    public Page<T> getAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    @Override
    public void delete(ID id) {

        T entity = getById(id);

        repository.delete(entity);
    }
}