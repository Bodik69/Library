package com.softserve.edu.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
    @Column(name="idOrder", nullable = false)
    private Integer idOrder;

    @ManyToOne
    @JoinColumn(name="idReader", nullable = false)
    private Reader reader;

    @ManyToOne
    @JoinColumn(name="inventoryNumber", nullable = false)
    private Copy copy;

    @Column(name="dataOrder", nullable = false)
    private Date dataOrder;

    @Column(name="dataReturn")
    private Date dataReturn;

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(idOrder).
                append(reader).
                append(copy).
                append(dataOrder).
                append(dataReturn).
                toHashCode();
    }
}
