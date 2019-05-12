package com.fmatusiak.libraryapi.repository;

import com.fmatusiak.libraryapi.domain.RentalBook;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RentalBookRepository extends CrudRepository<RentalBook, Long> {

    @Override
    Optional<RentalBook> findById(Long id);

    @Override
    RentalBook save(RentalBook rentalBook);

    @Override
    void delete(RentalBook rentalBook);
}
