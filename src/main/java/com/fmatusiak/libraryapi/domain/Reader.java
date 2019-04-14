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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "firstname")
    private final String firstName;

    @Column(name = "lastname")
    private final String lastname;

    @Column(name = "date_create_user")
    private LocalDate dateCreateUser = LocalDate.now();

    @OneToMany(mappedBy = "reader", fetch = FetchType.LAZY)
    private List<RentalBook> rentalBooks = new ArrayList<>();
}
