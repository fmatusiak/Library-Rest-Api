package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COPIES_BOOK")
public class CopyBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Setter
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_title_book", referencedColumnName = "id")
    private TitleBook titleBook;

    @OneToMany(mappedBy = "copyBook", fetch = FetchType.LAZY)
    private List<RentalBook> rentalBooks = new ArrayList<>();

    public CopyBook(String status, TitleBook titleBook) {
        this.status = status;
        this.titleBook = titleBook;
    }
}
