package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.ReaderDAO;
import com.softserve.edu.entity.Reader;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Богдан on 09.12.2015.
 */
@Repository
public class ReaderDAOImpl extends GenericDAOImpl<Reader> implements ReaderDAO{

    public ReaderDAOImpl() {
        super(Reader.class);
    }
}
