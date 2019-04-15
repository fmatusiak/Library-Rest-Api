package com.fmatusiak.libraryapi.repository;

import com.fmatusiak.libraryapi.domain.RentalBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RentalBookRepository extends CrudRepository<RentalBook, Long> {

    @Override
    List<RentalBook> findAll();

    @Override
    Optional<RentalBook> findById(Long id);

    @Override
    RentalBook save(RentalBook copyBook);

    @Override
    void delete(RentalBook copyBook);
}
