package com.fmatusiak.libraryapi.service;

import com.fmatusiak.libraryapi.domain.RentalBook;
import com.fmatusiak.libraryapi.domain.enums.RentalStatus;
import com.fmatusiak.libraryapi.repository.RentalBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.logging.Logger;

@Transactional
@Service
public class RentalBookService {

    private static final Logger LOGGER = Logger.getLogger(RentalBookService.class.getName());

    @Autowired
    private RentalBookRepository rentalBookRepository;

    @Autowired
    private CopyBookService copyBookService;

    public RentalBook rentalBook(RentalBook rentalBook) {
        if (checkStatusRentalBook(rentalBook)) {
            LOGGER.warning("This book is rented");
            return null;
        }
            copyBookService.setCopyBookStatusAsRented(rentalBook.getCopyBook().getId());
        return rentalBookRepository.save(rentalBook);

    }

    public void returnRentalBook(RentalBook rentalBook) {
        if (!checkStatusRentalBook(rentalBook)) {
            LOGGER.warning("This book was not rented");
        }
        copyBookService.setCopyBookStatusAsAvailable(rentalBook.getCopyBook().getId());
        rentalBookRepository.delete(rentalBook);
    }

    public RentalBook findRentalBookById(Long id) {
        return rentalBookRepository.findById(id).orElse(null);
    }

    private boolean checkStatusRentalBook(RentalBook rentalBook) {
        return rentalBook.getCopyBook()
                .getStatus()
                .equals(RentalStatus.RENTED.getStatus());
    }

}
