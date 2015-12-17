package com.softserve.edu.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
    @JoinColumn(name = "code", nullable = false)
    private Book book;

    @Column(name = "isInStock", nullable = false)
    private Boolean isInStock;

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(id).
                append(book).
                append(isInStock).
                toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Copy) {
            final Copy other = (Copy) obj;
            return new EqualsBuilder()
                    .append(id, other.id)
                    .append(book, other.book)
                    .append(isInStock, other.isInStock)
                    .isEquals();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Copy{"
                + "\n\tid=" + id
                + ", \n\tbook=" + book.getTitle()
                + ", \n\tisInStock=" + isInStock
                + "\n}";
    }
}
