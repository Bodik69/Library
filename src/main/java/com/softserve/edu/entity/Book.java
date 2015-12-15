package com.softserve.edu.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
    @Column(name="code", nullable = false)
    private Integer idBook;

    @Column(name="title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name="idAuthor")
    private Author author;

    @Column(name="edition", nullable = false)
    private  String edition;

    @Column(name="year", nullable = false)
    private Integer year;

    @Column(name="pages", nullable = false)
    private Integer pages;

    @Column(name="copyCount", nullable = false)
    private Integer copyCount;

    @ManyToMany(mappedBy="books", fetch = FetchType.LAZY)
    private Set<Author> coAuthors;

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(idBook).
                append(title).
                append(author).
                append(edition).
                append(year).
                append(pages).
                append(copyCount).
                toHashCode();
    }
}
