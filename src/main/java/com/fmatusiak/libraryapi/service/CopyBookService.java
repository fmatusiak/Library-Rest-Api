package com.fmatusiak.libraryapi.service;

import com.fmatusiak.libraryapi.domain.CopyBook;
import com.fmatusiak.libraryapi.domain.enums.RentalStatus;
import com.fmatusiak.libraryapi.repository.CopyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.logging.Logger;

@Transactional
@Service
public class CopyBookService {

    private static final Logger LOGGER = Logger.getLogger(CopyBookService.class.getName());

    @Autowired
    private CopyBookRepository copyBookRepository;

    public CopyBook copyBook(CopyBook copyBook) {
        return copyBookRepository.save(copyBook);
    }

    public void deleteCopyBook(CopyBook copyBook) {
        copyBookRepository.delete(copyBook);
    }

    public CopyBook findCopyBookById(Long id) {
        return copyBookRepository.findById(id).orElse(null);
    }

    public Long getCountCopyBooksAvailableByTitle(String title) {
        return copyBookRepository.countCopyBooksByStatusAndTitleBook_Title(
                RentalStatus.AVAILABLE.getStatus(), title);
    }

    public void setCopyBookStatusAsAvailable(Long copyBookId) {
            CopyBook copyBook = findCopyBookById(copyBookId);
        if (copyBook != null && !checkCopyBookStatus(copyBook)) {
            copyBook.setStatus(RentalStatus.AVAILABLE.getStatus());
            copyBookRepository.save(copyBook);
        }
        LOGGER.warning("This book have a status: AVAILABLE ");
    }

    public void setCopyBookStatusAsRented(Long copyBookId) {
            CopyBook copyBook = findCopyBookById(copyBookId);
        if (copyBook != null && checkCopyBookStatus(copyBook)) {
            copyBook.setStatus(RentalStatus.RENTED.getStatus());
            copyBookRepository.save(copyBook);
        }
        LOGGER.warning("This book have a status: RENTED ");
    }

    private boolean checkCopyBookStatus(CopyBook copyBook) {
        return copyBook.getStatus().equals(RentalStatus.AVAILABLE.getStatus());
    }
}
