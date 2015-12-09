package com.softserve.edu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Ruslan on 09.12.2015.
 */
@Getter
@Setter
@Entity
@Table(name = "OrderReader")
public class OrderReader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idOrder")
    private Integer idOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idReader")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name="inventoryNumber")
    private Copy copy;

    @Column(name="dataOrder")
    private Date dataOrder;

    @Column(name="dataReturn")
    private Date dataReturn;

}
