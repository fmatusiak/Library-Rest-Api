package com.fmatusiak.libraryapi.domain.dto;

import com.fmatusiak.libraryapi.domain.TitleBook;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CopyBookDto {
    private Long id;
    private String status;
    private TitleBook titleBook;
    private List<RentalBookDto> rentalBooks;
}
