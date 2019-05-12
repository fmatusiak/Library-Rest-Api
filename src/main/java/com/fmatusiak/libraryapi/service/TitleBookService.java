package com.fmatusiak.libraryapi.service;

import com.fmatusiak.libraryapi.domain.TitleBook;
import com.fmatusiak.libraryapi.repository.TitleBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class TitleBookService {

    @Autowired
    private TitleBookRepository titleBookRepository;

    public TitleBook saveTitleBook(TitleBook titleBook) {
        return titleBookRepository.save(titleBook);
    }

    public void deleteTitleBook(TitleBook titleBook) {
        titleBookRepository.delete(titleBook);
    }

    public TitleBook findTitleBookById(Long id) {
        return titleBookRepository.findById(id).orElse(null);
    }

    public List<TitleBook> findTitleBooksByAuthor(String author) {
        return titleBookRepository.findTitleBooksByAuthor(author);
    }

    public TitleBook findTitleBookByTitle(String title) {
        return titleBookRepository.findTitleBookByTitle(title);
    }
}
