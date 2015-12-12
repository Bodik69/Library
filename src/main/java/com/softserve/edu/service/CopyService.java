package com.softserve.edu.service;

import com.softserve.edu.entity.Author;
import com.softserve.edu.entity.Copy;

import java.util.List;


/**
 * Created by Ruslan on 11.12.2015.
 */
public interface CopyService {
    public void save(Copy copy);
    public void update(Copy copy);
    public Copy find(Integer elementId);
    public List<Copy> findAll();
    public void delete(Copy copy);
}
