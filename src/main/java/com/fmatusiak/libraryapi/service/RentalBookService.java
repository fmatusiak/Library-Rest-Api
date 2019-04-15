package com.fmatusiak.libraryapi.service;

import com.fmatusiak.libraryapi.domain.RentalBook;
import com.fmatusiak.libraryapi.repository.RentalBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalBookService {

    @Autowired
    private RentalBookRepository rentalBookRepository;

    public void saveRentalBook(RentalBook reader) {
        rentalBookRepository.save(reader);
    }

    public void deleteRentalBook(RentalBook copyBook) {
        rentalBookRepository.delete(copyBook);
    }

    public RentalBook findRentalBookById(Long id) {
        return rentalBookRepository.findById(id).orElse(null);
    }

    public List<RentalBook> findAllRentalBooks() {
        return rentalBookRepository.findAll();
    }
}
