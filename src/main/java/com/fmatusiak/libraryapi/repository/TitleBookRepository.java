package com.fmatusiak.libraryapi.repository;

import com.fmatusiak.libraryapi.domain.TitleBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TitleBookRepository extends CrudRepository<TitleBook, Long> {
    @Override
    List<TitleBook> findAll();

    @Override
    Optional<TitleBook> findById(Long id);

    @Override
    TitleBook save(TitleBook copyBook);

    @Override
    void delete(TitleBook copyBook);
}
