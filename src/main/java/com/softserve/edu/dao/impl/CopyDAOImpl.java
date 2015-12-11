package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.CopyDAO;
import com.softserve.edu.entity.Copy;
import org.springframework.stereotype.Repository;

/**
 * Created by Богдан on 09.12.2015.
 */
@Repository
public class CopyDAOImpl extends GenericDAOImpl<Copy> implements CopyDAO {

    public CopyDAOImpl() {
        super(Copy.class);
    }
}
