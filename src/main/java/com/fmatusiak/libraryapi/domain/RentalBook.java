package com.fmatusiak.libraryapi.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Entity
@Table(name = "RENTAL_BOOKS")
public class RentalBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "date_rental_book")
    private LocalDate dateRentalBook = LocalDate.now();

    @Column(name = "date_return_book")
    private LocalDate dateReturnBook;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_copy_book", referencedColumnName = "id")
    private CopyBook copyBook;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_reader", referencedColumnName = "id")
    private Reader reader;

    public RentalBook(LocalDate dateReturnBook, CopyBook copyBook, Reader reader) {
        this.dateReturnBook = dateReturnBook;
        this.copyBook = copyBook;
        this.reader = reader;
    }
}
