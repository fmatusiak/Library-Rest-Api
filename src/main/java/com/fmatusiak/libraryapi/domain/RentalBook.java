package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "rentalBooks")
public class RentalBook {
    private int idCopyBook;
    private int idReader;
    private LocalDate dateRentalBook;
    private LocalDate dateReturnBook;

    @Column(name = "idCopyBook")
    public int getIdCopyBook() {
        return idCopyBook;
    }

    @Column(name = "idReader")
    public int getIdReader() {
        return idReader;
    }

    @Column(name = "dateRentalBook")
    public LocalDate getDateRentalBook() {
        return dateRentalBook;
    }

    @Column(name = "dateReturnBook")
    public LocalDate getDateReturnBook() {
        return dateReturnBook;
    }
}
