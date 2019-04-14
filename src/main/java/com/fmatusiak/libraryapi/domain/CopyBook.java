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
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "STATUS")
    private final String status;

    @ManyToOne
    @JoinColumn(name = "ID_TITLE_BOOK", referencedColumnName = "ID")
    private TitleBook titleBook;

    @ManyToMany(mappedBy = "copyBook", fetch = FetchType.LAZY)
    private List<RentalBook> rentalBooks = new ArrayList<>();
}
