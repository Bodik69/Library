package com.softserve.edu.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.EqualsBuilder;
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

    @Override
    public boolean equals(final Object obj){
        if(obj instanceof OrderReader){
            final OrderReader other = (OrderReader) obj;
            return new EqualsBuilder()
                    .append(idOrder, other.idOrder)
                    .append(reader, other.reader)
                    .append(copy, other.copy)
                    .append(dataOrder, other.dataOrder)
                    .append(dataReturn, other.dataReturn)
                    .isEquals();
        } else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "OrderReader{" +
                "\n\tidOrder=" + idOrder +
                ", \n\treader=" + reader.getName() +
                ", \n\treader=" + reader.getSurname() +
                ", \n\tcopy=" + copy.getBook().getTitle() +
                ", \n\tdataOrder=" + dataOrder +
                ", \n\tdataReturn=" + dataReturn +
                "\n}";
    }
}
