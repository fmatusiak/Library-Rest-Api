package com.fmatusiak.libraryapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDto {
    private Long id;
    private String firstName;
    private String lastname;
    private LocalDate dateCreateUser;
    private List<RentalBookDto> rentalBooks;
}
