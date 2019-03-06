package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

/*@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TITLES")*/
public class TitleBook {
   /*
    @Id
    @GeneratedValue
    @Column(name = "ID_TITLE_BOOK",unique = true)
    private int id;

    @OneToMany(targetEntity = CopyBook.class,
               mappedBy = "ID_TITLE_BOOK")
    private ArrayList<CopyBook> copyBooks = new ArrayList<>();

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "YEAR_PUBLISHMENT")
    private int yearPublishment;*/

}
