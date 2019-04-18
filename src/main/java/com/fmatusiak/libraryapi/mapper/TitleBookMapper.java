package com.fmatusiak.libraryapi.mapper;

import com.fmatusiak.libraryapi.domain.TitleBook;
import com.fmatusiak.libraryapi.domain.dto.TitleBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleBookMapper {

    @Autowired
    private CopyBookMapper copyBookMapper;

    public TitleBook titleBookDtoToTitleBookDtoMapper(final TitleBookDto titleBookDto) {
        return new TitleBook(titleBookDto.getId(),
                titleBookDto.getTitle(),
                titleBookDto.getAuthor(),
                titleBookDto.getYearPublishment(),
                copyBookMapper.CopyBookDtoListToCopyBookListMapper(titleBookDto.getCopyBooks()));
    }

    public TitleBookDto titleBookToTitleBookDtoMapper(final TitleBook titleBook) {
        return new TitleBookDto(titleBook.getId(),
                titleBook.getTitle(),
                titleBook.getAuthor(),
                titleBook.getYearPublishment(),
                copyBookMapper.CopyBookListToCopyBookDtoListMapper(titleBook.getCopyBooks()));
    }

    public List<TitleBookDto> titleBookListToTitleBookDtoListMapper(final List<TitleBook> titleBookList) {
        return titleBookList.stream()
                .map(titleBook -> titleBookToTitleBookDtoMapper(titleBook))
                .collect(Collectors.toList());
    }

    public List<TitleBook> titleBookDtoListToTitleBookListMapper(final List<TitleBookDto> titleBookDtos) {
        return titleBookDtos.stream()
                .map(titleBookDto -> titleBookDtoToTitleBookDtoMapper(titleBookDto))
                .collect(Collectors.toList());
    }
}
