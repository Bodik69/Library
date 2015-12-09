package com.softserve.edu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Ihor Sokolyk on 09.12.2015.
 */
@Getter
@Setter
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

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="author_book", joinColumns=@JoinColumn(name="idAuthor"), inverseJoinColumns=@JoinColumn(name="code"))
    private Set<Book> books;


    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
