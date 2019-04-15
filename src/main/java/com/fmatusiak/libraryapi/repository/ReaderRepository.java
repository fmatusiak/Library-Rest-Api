package com.fmatusiak.libraryapi.repository;

import com.fmatusiak.libraryapi.domain.Reader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReaderRepository extends CrudRepository<Reader, Long> {

    @Override
    List<Reader> findAll();

    @Override
    Optional<Reader> findById(Long id);

    @Override
    Reader save(Reader copyBook);

    @Override
    void delete(Reader copyBook);
}
