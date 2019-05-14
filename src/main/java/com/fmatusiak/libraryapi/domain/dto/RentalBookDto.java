package com.fmatusiak.libraryapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RentalBookDto {
    private Long id;
    private LocalDate dateRentalBook = LocalDate.now();
    private LocalDate dateReturnBook;
    private Long copyBookId;
    private Long readerId;
}
