package com.fmatusiak.libraryapi.repository;

import com.fmatusiak.libraryapi.domain.RentalBook;
import org.springframework.data.repository.CrudRepository;

public interface RentalBookRepository extends CrudRepository<RentalBook, Long> {
}
