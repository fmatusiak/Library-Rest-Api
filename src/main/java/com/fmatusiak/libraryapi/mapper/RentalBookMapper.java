package com.fmatusiak.libraryapi.mapper;

import com.fmatusiak.libraryapi.domain.RentalBook;
import com.fmatusiak.libraryapi.domain.dto.RentalBookDto;
import com.fmatusiak.libraryapi.service.CopyBookService;
import com.fmatusiak.libraryapi.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentalBookMapper {

    @Autowired
    private CopyBookService copyBookService;

    @Autowired
    private ReaderService readerService;

    public RentalBook RentalBookDtoToRentalBookMapper(final RentalBookDto rentalBookDto) {
        return new RentalBook(rentalBookDto.getId(),
                rentalBookDto.getDateRentalBook(),
                rentalBookDto.getDateReturnBook(),
                copyBookService.findCopyBookById(rentalBookDto.getCopyBookId()),
                readerService.findReaderById(rentalBookDto.getReaderId()));
    }

    public RentalBookDto RentalBookToRentalBookDtoMapper(final RentalBook rentalBook) {
        return new RentalBookDto(rentalBook.getId(),
                rentalBook.getDateRentalBook(),
                rentalBook.getDateReturnBook(),
                rentalBook.getCopyBook().getId(),
                rentalBook.getReader().getId());
    }
}
