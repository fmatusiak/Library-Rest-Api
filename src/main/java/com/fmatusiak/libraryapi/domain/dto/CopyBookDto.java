package com.fmatusiak.libraryapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CopyBookDto {
    private Long id;
    private String status;
    private Long titleBookId;
    private List<Long> rentalBooksId = new ArrayList<>();
}
