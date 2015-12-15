package com.softserve.edu.entity;
import lombok.*;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Ruslan on 09.12.2015.
 */
@Getter
@Setter
@Entity
@Table(name = "reader")
public class Reader {
    @Id
    @Column(name = "idReader", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReader;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "adress", nullable = false)
    private String adress;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "birth", nullable = false)
    private Date birth;

    @Column(name = "dateOfCreate", nullable = false)
    private Date dateOfCreate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reader", cascade = CascadeType.ALL)
    private Set<OrderReader> orders;

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(idReader).
                append(name).
                append(surname).
                append(adress).
                append(phone).
                append(birth).
                append(dateOfCreate).
                toHashCode();
    }
}
