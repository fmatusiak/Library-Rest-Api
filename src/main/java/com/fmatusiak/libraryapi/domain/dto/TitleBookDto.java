package com.fmatusiak.libraryapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TitleBookDto {
    private int id;
    private String title;
    private String author;
    private int yearPublishment;
    private List<CopyBookDto> copyBooks;
}
