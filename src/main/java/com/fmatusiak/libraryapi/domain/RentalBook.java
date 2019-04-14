package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "RENTAL_BOOKS")
public class RentalBook {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "DATE_RENTAL_BOOK")
    private final LocalDate dateRentalBook;

    @Column(name = "DATE_RETURN_BOOK")
    private final LocalDate dateReturnBook;

    @ManyToOne
    @JoinColumn(name = "ID_COPY_BOOK", referencedColumnName = "ID")
    private CopyBook copyBook;

    @ManyToOne
    @JoinColumn(name = "ID_READER", referencedColumnName = "ID")
    private Reader reader;
}
