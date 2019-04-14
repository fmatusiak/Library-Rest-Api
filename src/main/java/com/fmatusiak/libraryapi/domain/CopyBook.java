package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "COPIES_BOOK")
public class CopyBook {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "status")
    private final String status;

    @ManyToOne
    @JoinColumn(name = "id_title_book", referencedColumnName = "id")
    private TitleBook titleBook;

    @OneToMany(mappedBy = "copyBook", fetch = FetchType.LAZY)
    private List<RentalBook> rentalBooks = new ArrayList<>();
}
