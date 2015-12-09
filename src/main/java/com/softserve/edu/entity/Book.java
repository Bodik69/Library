package com.softserve.edu.entity;

import javax.persistence.*;

/**
 * Created by Богдан on 09.12.2015.
 */

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

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getCopyCount() {
        return copyCount;
    }

    public void setCopyCount(Integer copyCount) {
        this.copyCount = copyCount;
    }
}
