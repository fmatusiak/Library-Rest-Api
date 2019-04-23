package com.fmatusiak.libraryapi.controller;

import com.fmatusiak.libraryapi.domain.TitleBook;
import com.fmatusiak.libraryapi.domain.dto.TitleBookDto;
import com.fmatusiak.libraryapi.mapper.TitleBookMapper;
import com.fmatusiak.libraryapi.service.TitleBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/titlebook")
public class TitleBookController {

    @Autowired
    private TitleBookService titleBookService;

    @Autowired
    private TitleBookMapper titleBookMapper;

    @PostMapping(value = "createTitleBook", consumes = APPLICATION_JSON_VALUE)
    public void createTitleBook(@RequestBody TitleBook titleBook) {
        titleBookMapper.titleBookToTitleBookDtoMapper(titleBookService.saveTitleBook(titleBook));
    }

    @DeleteMapping(value = "deleteTitleBook")
    public void deleteTitleBook(@RequestParam Long titleBookId) {
        titleBookService.deleteTitleBook(titleBookService.findTitleBookById(titleBookId));
    }

    @GetMapping(value = "findTitleBookById")
    public TitleBookDto findTitleBookById(@RequestParam Long titleBookId) {
        return titleBookMapper.titleBookToTitleBookDtoMapper(titleBookService.findTitleBookById(titleBookId));
    }

}
