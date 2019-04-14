package com.fmatusiak.libraryapi.repository;

import com.fmatusiak.libraryapi.domain.TitleBook;
import org.springframework.data.repository.CrudRepository;

public interface TitleBookRepository extends CrudRepository<TitleBook, Long> {

}
