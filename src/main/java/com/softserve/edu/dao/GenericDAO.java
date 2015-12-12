package com.softserve.edu.dao;

import java.util.List;

/**
 * Created by Богдан on 09.12.2015.
 */
public interface GenericDAO<E> {

    public void save(E element);

    public void update(E element);

    public E find(Integer elementId);

    public List<E> findAll();

    public void delete(Integer id);

}
