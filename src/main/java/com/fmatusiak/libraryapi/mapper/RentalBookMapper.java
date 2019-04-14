package com.fmatusiak.libraryapi.mapper;

import com.fmatusiak.libraryapi.domain.RentalBook;
import com.fmatusiak.libraryapi.domain.dto.RentalBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalBookMapper {

    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private CopyBookMapper copyBookMapper;

    public RentalBook RentalBookDtoToRentalBookMapper(RentalBookDto rentalBookDto) {
        return new RentalBook(rentalBookDto.getId(),
                rentalBookDto.getDateRentalBook(),
                rentalBookDto.getDateReturnBook(),
                copyBookMapper.CopyBookDtoToCopyBookMapper(rentalBookDto.getCopyBookDto()),
                readerMapper.ReaderDtoToReaderMapper(rentalBookDto.getReader()));
    }

    public RentalBookDto RentalBookToRentalBookDtoMapper(RentalBook rentalBook) {
        return new RentalBookDto(rentalBook.getId(),
                rentalBook.getDateRentalBook(),
                rentalBook.getDateReturnBook(),
                copyBookMapper.CopyBookToCopyBookDtoMapper(rentalBook.getCopyBook()),
                readerMapper.ReaderToReaderDtoMapper(rentalBook.getReader()));
    }

    public List<RentalBookDto> RentalBookListToRentalBookDtoMapper(List<RentalBook> rentalBooks) {
        return rentalBooks.stream()
                .map(rentalBook -> RentalBookToRentalBookDtoMapper(rentalBook))
                .collect(Collectors.toList());
    }

    public List<RentalBook> RentalBookDtoListToRentalBookMapper(List<RentalBookDto> rentalBooksDto) {
        return rentalBooksDto.stream()
                .map(rentalBookDto -> RentalBookDtoToRentalBookMapper(rentalBookDto))
                .collect(Collectors.toList());
    }
}
