package com.fmatusiak.libraryapi.mapper;

import com.fmatusiak.libraryapi.domain.CopyBook;
import com.fmatusiak.libraryapi.domain.dto.CopyBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyBookMapper {

    @Autowired
    private RentalBookMapper rentalBookMapper;

    public CopyBook CopyBookDtoToCopyBookMapper(CopyBookDto copyBookDto) {
        return new CopyBook(copyBookDto.getId(),
                copyBookDto.getStatus(),
                copyBookDto.getTitleBook(),
                rentalBookMapper.RentalBookDtoListToRentalBookMapper(copyBookDto.getRentalBooks()));
    }

    public CopyBookDto CopyBookToCopyBookDtoMapper(CopyBook copyBook) {
        return new CopyBookDto(copyBook.getId(),
                copyBook.getStatus(),
                copyBook.getTitleBook(),
                rentalBookMapper.RentalBookListToRentalBookDtoMapper(copyBook.getRentalBooks()));
    }

    public List<CopyBook> CopyBookDtoListToCopyBookListMapper(List<CopyBookDto> copyBookDtos) {
        return copyBookDtos.stream()
                .map(copyBookDto -> CopyBookDtoToCopyBookMapper(copyBookDto))
                .collect(Collectors.toList());
    }

    public List<CopyBookDto> CopyBookListToCopyBookDtoListMapper(List<CopyBook> copyBooks) {
        return copyBooks.stream()
                .map(copyBook -> CopyBookToCopyBookDtoMapper(copyBook))
                .collect(Collectors.toList());
    }
}
