package com.fmatusiak.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "readers")
public class Reader {
    private int id;
    private String name;
    private String surname;
    private LocalDate dateCreateNewUser;

    public Reader(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.dateCreateNewUser = LocalDate.now();
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    @Column(name = "DateCreateUser")
    public LocalDate getDateCreateNewUser() {
        return dateCreateNewUser;
    }
}
