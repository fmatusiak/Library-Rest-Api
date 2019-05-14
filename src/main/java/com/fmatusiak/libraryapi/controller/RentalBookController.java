package com.fmatusiak.libraryapi.controller;

import com.fmatusiak.libraryapi.domain.RentalBook;
import com.fmatusiak.libraryapi.domain.dto.RentalBookDto;
import com.fmatusiak.libraryapi.mapper.RentalBookMapper;
import com.fmatusiak.libraryapi.service.CopyBookService;
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

    @Autowired
    private CopyBookService copyBookService;

    @PostMapping(value = "rentBook", consumes = APPLICATION_JSON_VALUE)
    public RentalBook rentBook(@RequestBody RentalBookDto rentalBookDto) {
        copyBookService.setCopyBookStatusAsRented(rentalBookDto.getCopyBookId());
        return rentalBookService.rentalBook(rentalBookMapper.RentalBookDtoToRentalBookMapper(rentalBookDto));
    }

    @DeleteMapping(value = "returnBook")
    public void returnBook(@RequestParam Long rentalBookId) {
        copyBookService.setCopyBookStatusAsAvailable(
                rentalBookService.findRentalBookById(rentalBookId).getCopyBook().getId());
        rentalBookService.returnRentalBook(
                rentalBookService.findRentalBookById(rentalBookId));
    }

    @GetMapping(value = "findBookById")
    public RentalBookDto findBookById(@RequestParam Long rentalBookId) {
        return rentalBookMapper.RentalBookToRentalBookDtoMapper(rentalBookService.findRentalBookById(rentalBookId));
    }

}
