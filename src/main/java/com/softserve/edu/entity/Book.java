package com.softserve.edu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Богдан on 09.12.2015.
 */

@Getter
@Setter
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="code")
    private Integer idBook;

    @Column(name="title")
    private String title;

    @Column(name="edition")
    private  String edition;

    @Column(name="idAuthor")
    private Author author;

    @Column(name="year")
    private Integer year;

    @Column(name="pages")
    private Integer pages;

    @Column(name="copyCount")
    private Integer copyCount;

    private Set<Author> authors;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    public Set<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
