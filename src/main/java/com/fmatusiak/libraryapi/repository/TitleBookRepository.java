package com.fmatusiak.libraryapi.repository;

import com.fmatusiak.libraryapi.domain.TitleBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TitleBookRepository extends CrudRepository<TitleBook, Long> {

    @Override
    Optional<TitleBook> findById(Long id);

    @Override
    TitleBook save(TitleBook titleBook);

    @Override
    void delete(TitleBook titleBook);

    TitleBook findTitleBookByTitle(String title);

    List<TitleBook> findTitleBooksByAuthor(String author);

}
