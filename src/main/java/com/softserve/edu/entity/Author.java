package com.softserve.edu.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
    @Column(name="idAuthor", nullable = false)
    private Integer idAuthor;

    @Column(name="firstName", nullable = false)
    private String firstName;

    @Column(name="lastName", nullable = false)
    private String lastName;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="author_book", joinColumns=@JoinColumn(name="idAuthor"), inverseJoinColumns=@JoinColumn(name="code"))
    private Set<Book> books;

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(idAuthor).
                append(firstName).
                append(lastName).
                toHashCode();
    }
}
