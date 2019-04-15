package com.fmatusiak.libraryapi.service;

import com.fmatusiak.libraryapi.domain.CopyBook;
import com.fmatusiak.libraryapi.repository.CopyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyBookService {

    @Autowired
    private CopyBookRepository copyBookRepository;

    public void saveCopyBook(CopyBook copyBook) {
        copyBookRepository.save(copyBook);
    }

    public void deleteCopyBook(CopyBook copyBook) {
        copyBookRepository.delete(copyBook);
    }

    public CopyBook findCopyBookById(Long id) {
        return copyBookRepository.findById(id).orElse(null);
    }

    public List<CopyBook> findAllCopyBook() {
        return copyBookRepository.findAll();
    }
}
