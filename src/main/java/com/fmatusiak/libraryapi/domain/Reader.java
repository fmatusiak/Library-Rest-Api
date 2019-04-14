package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "READERS")
public class Reader {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private final String firstName;

    @Column(name = "LASTNAME")
    private final String lastname;

    @Column(name = "DATE_CREATER_USER")
    private LocalDate dateCreateUser = LocalDate.now();

    @OneToMany(mappedBy = "reader")
    private List<RentalBook> rentalBooks = new ArrayList<>();
}
