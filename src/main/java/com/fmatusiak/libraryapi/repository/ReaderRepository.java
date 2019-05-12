package com.fmatusiak.libraryapi.repository;

import com.fmatusiak.libraryapi.domain.Reader;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReaderRepository extends CrudRepository<Reader, Long> {

    @Override
    Optional<Reader> findById(Long id);

    @Override
    Reader save(Reader reader);

    @Override
    void delete(Reader reader);

    Reader findReaderByFirstnameAndLastname(String firstname, String lastname);
}
