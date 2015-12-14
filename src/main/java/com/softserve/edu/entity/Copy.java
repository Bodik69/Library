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
    @Column(name = "inventoryNumber", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="code", nullable = false)
    private Book book;

    @Column(name = "isInStock", nullable = false)
    private Boolean isInStock;
}
