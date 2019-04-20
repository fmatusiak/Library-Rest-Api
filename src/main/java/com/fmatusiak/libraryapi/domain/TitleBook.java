package com.fmatusiak.libraryapi.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "TITLES_BOOKS")
public class TitleBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "year_publishment")
    private int yearPublishment;

    @OneToMany(mappedBy = "titleBook", fetch = FetchType.LAZY)
    private List<CopyBook> copyBooks = new ArrayList<>();

    public TitleBook(String title, String author, int yearPublishment) {
        this.title = title;
        this.author = author;
        this.yearPublishment = yearPublishment;
    }
}
