package com.softserve.edu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}
