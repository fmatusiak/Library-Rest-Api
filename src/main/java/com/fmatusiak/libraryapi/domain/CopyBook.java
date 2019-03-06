package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "COPIES_BOOK")*/
public class CopyBook {

   /* @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID_COPY_BOOK")
    private int id;

    @Column(name = "ID_TITLE_BOOK")
    private int idTitleBook;

    @Column(name = "STATUS")
    private String status;

    public CopyBook(String status) {
        this.status = status;
    }*/
}
