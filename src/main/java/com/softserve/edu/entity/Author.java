package com.softserve.edu.entity;

import javax.persistence.*;

/**
 * Created by Ihor Sokolyk on 09.12.2015.
 */
@Entity
@Table(name="author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idAuthor")
    private Integer idAuthor;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
