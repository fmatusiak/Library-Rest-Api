package com.fmatusiak.libraryapi.service;

import com.fmatusiak.libraryapi.domain.RentalBook;
import com.fmatusiak.libraryapi.repository.RentalBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RentalBookService {

    @Autowired
    private RentalBookRepository rentalBookRepository;

    public RentalBook saveRentalBook(RentalBook rentalBook) {
        return rentalBookRepository.save(rentalBook);
    }

    public void deleteRentalBook(RentalBook rentalBook) {
        rentalBookRepository.delete(rentalBook);
    }

    public RentalBook findRentalBookById(Long id) {
        return rentalBookRepository.findById(id).orElse(null);
    }

    public List<RentalBook> findAllRentalBooks() {
        return rentalBookRepository.findAll();
    }

}
