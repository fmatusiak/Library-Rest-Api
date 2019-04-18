package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RENTAL_BOOKS")
public class RentalBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "date_rental_book")
    private final LocalDate dateRentalBook;

    @Column(name = "date_return_book")
    private final LocalDate dateReturnBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_copy_book", referencedColumnName = "id")
    private final CopyBook copyBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reader", referencedColumnName = "id")
    private final Reader reader;
}
