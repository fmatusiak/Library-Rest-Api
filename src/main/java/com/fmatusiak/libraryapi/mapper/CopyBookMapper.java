package com.fmatusiak.libraryapi.mapper;

import com.fmatusiak.libraryapi.domain.CopyBook;
import com.fmatusiak.libraryapi.domain.RentalBook;
import com.fmatusiak.libraryapi.domain.TitleBook;
import com.fmatusiak.libraryapi.domain.dto.CopyBookDto;
import com.fmatusiak.libraryapi.service.RentalBookService;
import com.fmatusiak.libraryapi.service.TitleBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyBookMapper {

    @Autowired
    private RentalBookService rentalBookService;

    @Autowired
    private TitleBookService titleBookService;

    public CopyBook CopyBookDtoToCopyBookMapper(CopyBookDto copyBookDto) {
        return new CopyBook(copyBookDto.getId(),
                copyBookDto.getStatus(),
                getTitleBookWithId(copyBookDto.getTitleBookId()),
                getListRentalBookWithId(copyBookDto.getRentalBooksId()));
    }

    public CopyBookDto CopyBookToCopyBookDtoMapper(CopyBook copyBook) {
        return new CopyBookDto(copyBook.getId(),
                copyBook.getStatus(),
                Long.valueOf(copyBook.getTitleBook().getId()),
                getListRentalBookId(copyBook.getRentalBooks()));
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

    private RentalBook getRentalBookWithId(Long rentalBookId) {
        if (rentalBookId == null || rentalBookId == 0)
            return null;
        return rentalBookService.findRentalBookById(rentalBookId);
    }

    private TitleBook getTitleBookWithId(Long titleBookId) {
        if (titleBookId == null || titleBookId == 0)
            return null;
        return titleBookService.findTitleBookById(titleBookId);
    }

    private Long getIdWithTitleBook(TitleBook titleBook) {
        return Long.valueOf(titleBook.getId());
    }

    private List<RentalBook> getListRentalBookWithId(List<Long> itemsId) {
        if (itemsId == null)
            return null;
        return itemsId.stream()
                .map(itemId -> getRentalBookWithId(itemId))
                .collect(Collectors.toList());
    }

    private List<Long> getListRentalBookId(List<RentalBook> rentalBooks) {
        try {
            return rentalBooks.stream()
                    .map(rentalBook -> rentalBook.getId())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return null;
        }
    }

}
