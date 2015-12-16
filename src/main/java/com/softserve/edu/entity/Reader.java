package com.softserve.edu.entity;
import lombok.*;
import org.apache.commons.lang.builder.EqualsBuilder;
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

    @Override
    public boolean equals(final Object obj){
        if(obj instanceof Reader){
            final Reader other = (Reader) obj;
            return new EqualsBuilder()
                    .append(name, other.name)
                    .append(surname, other.surname)
                    .append(adress, other.adress)
                    .append(phone, other.phone)
                    .append(birth, other.birth)
                    .append(dateOfCreate, other.dateOfCreate)
                    .append(orders, other.orders)
                    .isEquals();
        } else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "\n\tidReader = " + idReader +
                ", \n\tname = " + name +
                ", \n\tsurname = " + surname +
                ", \n\tadress = " + adress +
                ", \n\tphone = " + phone +
                ", \n\tbirth = " + birth +
                ", \n\tdateOfCreate = " + dateOfCreate +
                "\n}";
    }
}
