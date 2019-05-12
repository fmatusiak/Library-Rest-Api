package com.fmatusiak.libraryapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class RentalBookDto {
    private Long id;
    private LocalDate dateRentalBook;
    private LocalDate dateReturnBook;
    private Long copyBookId;
    private Long readerId;
}
