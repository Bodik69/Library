package com.softserve.edu.entity;
import lombok.*;
import javax.persistence.*;

/**
 * Created by Ruslan on 09.12.2015.
 */
@Getter
@Setter
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


}
