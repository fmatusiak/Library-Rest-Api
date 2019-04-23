package com.fmatusiak.libraryapi.controller;

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

    @Autowired
    private CopyBookController copyBookController;

    @PostMapping(value = "rentBook", consumes = APPLICATION_JSON_VALUE)
    public void rentBook(@RequestBody RentalBookDto rentalBookDto) {
        copyBookController.setCopyBookStatusAsRented(rentalBookDto.getCopyBookId());
        rentalBookService.saveRentalBook(rentalBookMapper.RentalBookDtoToRentalBookMapper(rentalBookDto));
    }

    @DeleteMapping(value = "returnBook")
    public void returnBook(@RequestParam Long rentalBookId) {
        copyBookController.setCopyBookStatusAsAvailable(
                rentalBookService.findRentalBookById(rentalBookId).getCopyBook().getId());
        rentalBookService.deleteRentalBook(
                rentalBookService.findRentalBookById(rentalBookId));
    }

    @GetMapping(value = "findBookById")
    public RentalBookDto findBookById(@RequestParam Long rentalBookId) {
        return rentalBookMapper.RentalBookToRentalBookDtoMapper(rentalBookService.findRentalBookById(rentalBookId));
    }

}
