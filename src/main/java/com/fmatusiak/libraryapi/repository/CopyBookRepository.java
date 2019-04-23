package com.fmatusiak.libraryapi.repository;

import com.fmatusiak.libraryapi.domain.CopyBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CopyBookRepository extends CrudRepository<CopyBook, Long> {

    @Override
    List<CopyBook> findAll();

    @Override
    Optional<CopyBook> findById(Long id);

    @Override
    CopyBook save(CopyBook copyBook);

    @Override
    void delete(CopyBook copyBook);

    long countCopyBookByTitleBook_Title(String title);
}

