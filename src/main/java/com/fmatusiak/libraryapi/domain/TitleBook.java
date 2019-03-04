package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "titles")
public class TitleBook {
    private int id;
    private String title;
    private String author;
    private int yearPublishment;

    public TitleBook(String title, String author, int yearPublishment) {
        this.title = title;
        this.author = author;
        this.yearPublishment = yearPublishment;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    @Column(name = "yearPublishment")
    public int getYearPublishment() {
        return yearPublishment;
    }
}
