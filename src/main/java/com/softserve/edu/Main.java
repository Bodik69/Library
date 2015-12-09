package com.softserve.edu;

import com.softserve.edu.entity.Reader;
import com.softserve.edu.util.HibernateUtil;
import org.hibernate.Session;


/**
 * Created by Ihor Sokolyk on 09.12.2015.
 */
public class Main {
    public static void main(String[] args) {

        Session session = null;
        try { session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) {  session.close();   }
        }
    }
}

