package com.softserve.edu.entity;
import javax.persistence.*;

/**
 * Created by Ruslan on 09.12.2015.
 */

@Entity
@Table(name = "reader")  // @Table is optional
public class Reader {
    @Id
    @Column(name = "idReader")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReader;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "adress")
    private String adress;
    @Column(name = "phone")
    private String phone;
    @Column(name = "birth")
    private String birth;
    @Column(name = "dateOfCreate")
    private String dateOfCreate;

    public Integer getIdReader() {
        return idReader;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirth() {
        return birth;
    }

    public String getDateOfCreate() {
        return dateOfCreate;
    }

    public void setIdReader(Integer idReader) {
        this.idReader = idReader;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setDateOfCreate(String dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }
}
