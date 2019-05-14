package com.fmatusiak.libraryapi.mapper;

import com.fmatusiak.libraryapi.domain.Reader;
import com.fmatusiak.libraryapi.domain.RentalBook;
import com.fmatusiak.libraryapi.domain.dto.ReaderDto;
import com.fmatusiak.libraryapi.service.RentalBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    @Autowired
    private RentalBookService rentalBookService;

    public Reader ReaderDtoToReaderMapper(final ReaderDto readerDto) {
        return new Reader(readerDto.getId(),
                readerDto.getFirstname(),
                readerDto.getLastname(),
                readerDto.getDateCreateUser(),
                getListRentalBooksById(readerDto.getRentalBooksId()));
    }

    public ReaderDto ReaderToReaderDtoMapper(final Reader reader) {
        return new ReaderDto(reader.getId(),
                reader.getFirstname(),
                reader.getLastname(),
                reader.getDateCreateUser(),
                getListRentalBooksWithId(reader.getRentalBooks()));
    }

    private List<Long> getListRentalBooksWithId(final List<RentalBook> rentalBooks) {
        return rentalBooks.stream()
                .map(rentalBookDto -> rentalBookDto.getId())
                .collect(Collectors.toList());
    }

    private List<RentalBook> getListRentalBooksById(final List<Long> rentalBooksId) {
        return rentalBooksId.stream()
                .map(aLong -> rentalBookService.findRentalBookById(aLong))
                .collect(Collectors.toList());
    }


}
