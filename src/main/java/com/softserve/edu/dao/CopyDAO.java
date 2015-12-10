package com.softserve.edu.dao;

import com.softserve.edu.entity.Copy;

import java.util.List;

/**
 * Created by Ruslan on 10.12.2015.
 */
public interface CopyDAO {
    public void save(Copy copy);
    public void update(Copy copy);
    public Copy find(Integer elementId);
    public List <Copy> findAll();
    public void delete(Copy copy);
}
