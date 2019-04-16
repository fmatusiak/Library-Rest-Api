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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "title")
    private final String title;

    @Column(name = "author")
    private final String author;

    @Column(name = "year_publishment")
    private final int yearPublishment;

    @OneToMany(mappedBy = "titleBook", fetch = FetchType.LAZY)
    private List<CopyBook> copyBooks = new ArrayList<>();
}
