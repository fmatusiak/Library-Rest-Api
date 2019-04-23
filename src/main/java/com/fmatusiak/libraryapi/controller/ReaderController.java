package com.fmatusiak.libraryapi.controller;

import com.fmatusiak.libraryapi.domain.Reader;
import com.fmatusiak.libraryapi.domain.dto.ReaderDto;
import com.fmatusiak.libraryapi.mapper.ReaderMapper;
import com.fmatusiak.libraryapi.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @Autowired
    private ReaderMapper readerMapper;

    @PostMapping(value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody Reader reader) {
        readerMapper.ReaderToReaderDtoMapper(readerService.saveReader(reader));
    }

    @DeleteMapping(value = "deleteReader")
    public void deleteReader(@RequestParam Long readerId) {
        readerService.deleteReader(readerService.findReaderById(readerId));
    }

    @GetMapping(value = "findReaderById")
    public ReaderDto findReaderById(@RequestParam Long readerId) {
        return readerMapper.ReaderToReaderDtoMapper(readerService.findReaderById(readerId));
    }

}
