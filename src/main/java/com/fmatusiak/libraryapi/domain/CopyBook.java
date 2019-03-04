package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "copiesBook")
public class CopyBook {
    private int id;
    private int idTitleBook;
    private String statusBook;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @Column(name = "idTitleBook")
    public int getIdTitleBook() {
        return idTitleBook;
    }

    @Column(name = "idStatusBook")
    public String getStatusBook() {
        return statusBook;
    }
}
