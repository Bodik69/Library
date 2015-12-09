package com.softserve.edu;
import com.softserve.edu.entity.Author;
import com.softserve.edu.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by Ihor Sokolyk on 09.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        Session session = null;
        try { session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(author);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) {  session.close();   }
        }   }
}

