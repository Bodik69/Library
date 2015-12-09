package com.softserve.edu;
import com.softserve.edu.entity.Author;
import com.softserve.edu.entity.Reader;
import com.softserve.edu.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.Date;

/**
 * Created by Ihor Sokolyk on 09.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.setAdress("aaa");
        reader.setBirth("aaa");
        reader.setName("aaa");
        reader.setPhone("aaa");
        Session session = null;
        try { session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(reader);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) {  session.close();   }
        }   }
}

