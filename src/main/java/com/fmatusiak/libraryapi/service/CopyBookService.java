package com.fmatusiak.libraryapi.service;

import com.fmatusiak.libraryapi.domain.CopyBook;
import com.fmatusiak.libraryapi.domain.enums.RentalStatus;
import com.fmatusiak.libraryapi.repository.CopyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CopyBookService {

    @Autowired
    private CopyBookRepository copyBookRepository;

    public CopyBook saveCopyBook(CopyBook copyBook) {
        return copyBookRepository.save(copyBook);
    }

    public void deleteCopyBook(CopyBook copyBook) {
        copyBookRepository.delete(copyBook);
    }

    public CopyBook findCopyBookById(Long id) {
        return copyBookRepository.findById(id).orElse(null);
    }

    public List<CopyBook> findAllCopyBooks() {
        return copyBookRepository.findAll();
    }

    public void setCopyBookStatusAsAvailable(Long copyBookId) {
            CopyBook copyBook = findCopyBookById(copyBookId);
            copyBook.setStatus(RentalStatus.AVAILABLE.getStatus());
            copyBookRepository.save(copyBook);

    }

    public void setCopyBookStatusAsRented(Long copyBookId) {
            CopyBook copyBook = findCopyBookById(copyBookId);
            copyBook.setStatus(RentalStatus.RENTED.getStatus());
            copyBookRepository.save(copyBook);
    }
}
