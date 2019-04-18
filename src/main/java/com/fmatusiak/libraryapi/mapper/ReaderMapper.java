package com.fmatusiak.libraryapi.mapper;

import com.fmatusiak.libraryapi.domain.Reader;
import com.fmatusiak.libraryapi.domain.dto.ReaderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    @Autowired
    private RentalBookMapper rentalBookMapper;

    public Reader ReaderDtoToReaderMapper(final ReaderDto readerDto) {
        return new Reader(readerDto.getId(),
                readerDto.getFirstname(),
                readerDto.getLastname(),
                readerDto.getDateCreateUser(),
                rentalBookMapper.RentalBookDtoListToRentalBookMapper(readerDto.getRentalBooks()));
    }

    public ReaderDto ReaderToReaderDtoMapper(final Reader reader) {
        return new ReaderDto(reader.getId(),
                reader.getFirstname(),
                reader.getLastname(),
                reader.getDateCreateUser(),
                rentalBookMapper.RentalBookListToRentalBookDtoMapper(reader.getRentalBooks()));
    }

    public List<ReaderDto> ReaderListToReaderDtoListMapper(final List<Reader> readerList) {
        return readerList.stream()
                .map(reader -> ReaderToReaderDtoMapper(reader))
                .collect(Collectors.toList());
    }

    public List<Reader> ReaderListDtoToReaderListMapper(final List<ReaderDto> readerDtos) {
        return readerDtos.stream()
                .map(readerDto -> ReaderDtoToReaderMapper(readerDto))
                .collect(Collectors.toList());
    }
}
