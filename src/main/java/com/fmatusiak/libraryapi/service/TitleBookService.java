package com.fmatusiak.libraryapi.service;

import com.fmatusiak.libraryapi.domain.TitleBook;
import com.fmatusiak.libraryapi.repository.TitleBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleBookService {

    @Autowired
    private TitleBookRepository titleBookRepository;

    public void saveTitleBook(TitleBook titleBook) {
        titleBookRepository.save(titleBook);
    }

    public void deleteTitleBook(TitleBook titleBook) {
        titleBookRepository.delete(titleBook);
    }

    public TitleBook findTitleBookById(Long id) {
        return titleBookRepository.findById(id).orElse(null);
    }

    public List<TitleBook> findAllTitleBooks() {
        return titleBookRepository.findAll();
    }
}
