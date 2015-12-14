package com.softserve.edu.service.impl;

import com.softserve.edu.dao.AuthorDAO;
import com.softserve.edu.dao.BookDAO;
import com.softserve.edu.dao.CopyDAO;
import com.softserve.edu.entity.Author;
import com.softserve.edu.entity.Book;
import com.softserve.edu.entity.Copy;
import com.softserve.edu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Богдан on 10.12.2015.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private AuthorDAO authorDAO;

    @Autowired
    private CopyDAO copyDAO;

    @Override
    public Book find(Integer id) {
        return bookDAO.find(id);
    }

    @Override
    public void save(Book book) {
        Author author = authorDAO.findAuthorByFullName(book.getAuthor().getFirstName(), book.getAuthor().getLastName());
        if(author == null) {
            authorDAO.save(book.getAuthor());
        }
        if(book.getAuthor().getBooks() == null) {
            book.getAuthor().setBooks(new HashSet<Book>());
        }
        book.getAuthor().getBooks().add(book);
        for(int i = 0; i < book.getCopyCount(); i++) {
            Copy copy = new Copy();
            copy.setBook(book);
            copy.setIsInStock(true);
            copyDAO.save(copy);
        }
        bookDAO.save(book);
    }

    @Override
    public void update(Book book) {
        bookDAO.update(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public void delete(Integer id) {
        bookDAO.delete(id);
    }
}
