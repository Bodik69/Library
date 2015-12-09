package com.softserve.edu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Богдан on 09.12.2015.
 */
@Getter
@Setter
@Entity
@Table(name = "copy")
public class Copy {

    @Id
    @Column(name = "inventoryNumber")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="code")
    private Book book;

    @Column(name = "isInStock")
    private Boolean isInStock;
}
