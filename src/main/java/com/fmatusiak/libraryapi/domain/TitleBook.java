package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "TITLES_BOOKS")
public class TitleBook {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private int id;

    @Column(name = "TITLE")
    private final String title;

    @Column(name = "AUTHOR")
    private final String author;

    @Column(name = "YEAR_PUBLISHMENT")
    private final int yearPublishment;

    @OneToMany(mappedBy = "titleBook", fetch = FetchType.LAZY)
    private List<CopyBook> copyBooks = new ArrayList<>();
}
