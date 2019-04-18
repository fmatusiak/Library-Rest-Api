package com.fmatusiak.libraryapi.controller;

import com.fmatusiak.libraryapi.domain.RentalBook;
import com.fmatusiak.libraryapi.domain.dto.RentalBookDto;
import com.fmatusiak.libraryapi.mapper.RentalBookMapper;
import com.fmatusiak.libraryapi.service.RentalBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/rentalbook")
public class RentalBookController {

    @Autowired
    private RentalBookService rentalBookService;

    @Autowired
    private RentalBookMapper rentalBookMapper;

    @PostMapping(value = "saveRentalBook", consumes = APPLICATION_JSON_VALUE)
    public void saveRentalBook(@RequestBody RentalBook rentalBook) {
        rentalBookService.saveRentalBook(rentalBook);
    }

    @DeleteMapping(value = "deleteRentalBook")
    public void deleteRentalBook(@RequestParam Long rentalBookId) {
        rentalBookService.deleteRentalBook(rentalBookService.findRentalBookById(rentalBookId));
    }

    @GetMapping(value = "findRentalBookById")
    public RentalBookDto findRentalBookById(@RequestParam Long rentalBookId) {
        return rentalBookMapper.RentalBookToRentalBookDtoMapper(rentalBookService.findRentalBookById(rentalBookId));
    }

}
