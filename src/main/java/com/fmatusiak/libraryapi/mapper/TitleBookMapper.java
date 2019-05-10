package com.fmatusiak.libraryapi.mapper;

import com.fmatusiak.libraryapi.domain.CopyBook;
import com.fmatusiak.libraryapi.domain.TitleBook;
import com.fmatusiak.libraryapi.domain.dto.TitleBookDto;
import com.fmatusiak.libraryapi.service.CopyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleBookMapper {

    @Autowired
    private CopyBookMapper copyBookMapper;

    @Autowired
    private CopyBookService copyBookService;

    public TitleBook titleBookDtoToTitleBookMapper(final TitleBookDto titleBookDto) {
        return new TitleBook(titleBookDto.getId(),
                titleBookDto.getTitle(),
                titleBookDto.getAuthor(),
                titleBookDto.getYearPublishment(),
                getListCopyBookWithId(titleBookDto.getCopyBooksId()));
    }

    public TitleBookDto titleBookToTitleBookDtoMapper(final TitleBook titleBook) {
        return new TitleBookDto(titleBook.getId(),
                titleBook.getTitle(),
                titleBook.getAuthor(),
                titleBook.getYearPublishment(),
                getListCopyBookId(titleBook.getCopyBooks()));
    }
/*
    public List<TitleBookDto> titleBookListToTitleBookDtoListMapper(final List<TitleBook> titleBookList) {
        return titleBookList.stream()
                .map(titleBook -> titleBookToTitleBookDtoMapper(titleBook))
                .collect(Collectors.toList());
    }

    public List<TitleBook> titleBookDtoListToTitleBookListMapper(final List<TitleBookDto> titleBookDtos) {
        return titleBookDtos.stream()
                .map(titleBookDto -> titleBookDtoToTitleBookMapper(titleBookDto))
                .collect(Collectors.toList());
    }*/

    private Long getIdWithCopyBook(final CopyBook copyBook) {
        if (copyBook.getId() == null) {
            return null;
        }
        return copyBook.getId();
    }
/*
    private CopyBook getCopyBookWithId(final Long copyBookId) {
        if (copyBookId == null) {
            return null;
        }
        return copyBookService.findCopyBookById(copyBookId);
    }*/

    private List<Long> getListCopyBookId(final List<CopyBook> copyBooks) {
        try {
            return copyBooks.stream()
                    .map(copyBook -> getIdWithCopyBook(copyBook))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            return null;
        }
    }

    private List<CopyBook> getListCopyBookWithId(final List<Long> copyBooksId) {
        try {
            return copyBooksId.stream()
                    .map(aLong -> copyBookService.findCopyBookById(aLong))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            return null;
        }
    }


}
