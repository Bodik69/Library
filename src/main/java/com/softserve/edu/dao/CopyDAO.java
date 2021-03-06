package com.softserve.edu.dao;

import com.softserve.edu.entity.Book;
import com.softserve.edu.entity.Copy;

import java.util.List;

/**
 * Created by Ruslan on 10.12.2015.
 */
public interface CopyDAO extends GenericDAO<Copy> {
    public Copy findCopyByInventory(Integer id);

    public List getAllCopiesOfBook(Integer idOfBook);
}
