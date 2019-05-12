package com.fmatusiak.libraryapi.repository;

import com.fmatusiak.libraryapi.domain.CopyBook;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CopyBookRepository extends CrudRepository<CopyBook, Long> {

    @Override
    Optional<CopyBook> findById(Long id);

    @Override
    CopyBook save(CopyBook copyBook);

    @Override
    void delete(CopyBook copyBook);

    long countCopyBooksByStatusAndTitleBook_Title(String status, String title);
}

