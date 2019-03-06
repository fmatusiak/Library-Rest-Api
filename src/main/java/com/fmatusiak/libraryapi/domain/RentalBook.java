package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/*
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RENTAL_BOOKS")
*/
public class RentalBook {

   /* @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID_RENTAL_BOOK")
    private int id;


    @Column(name = "ID_COPY_BOOK")
    private int idCopyBook;

    @Column(name = "ID_READER")
    private int idReader;

    @Column(name = "DATE_RENTAL_BOOK")
    private LocalDate dateRentalBook;

    @Column(name = "DATE_RETURN_BOOK")
    private LocalDate dateReturnBook;
*/
}
