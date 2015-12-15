package com.softserve.edu.service.impl;

import com.softserve.edu.dao.AuthorDAO;
import com.softserve.edu.dao.BookDAO;
import com.softserve.edu.dao.CopyDAO;
import com.softserve.edu.entity.Author;
import com.softserve.edu.entity.Book;
import com.softserve.edu.entity.Copy;
import com.softserve.edu.service.BookService;
import com.softserve.edu.service.CopyService;
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

    @Autowired
    private CopyService copyService;

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
        else {
            book.setAuthor(author);
        }
        addBookToAuthor(book);
        bookDAO.save(book);
        for(int i = 0; i < book.getCopyCount(); i++) {
            Copy copy = new Copy();
            copy.setBook(book);
            copy.setIsInStock(true);
            copyDAO.save(copy);
        }
    }

    @Override
    public void addBookCopy(Integer idBook) {
        Book book = bookDAO.find(idBook);
        if(book != null) {
            book.setCopyCount(book.getCopyCount() + 1);
            Copy copy = new Copy();
            copy.setBook(book);
            copy.setIsInStock(true);
            bookDAO.update(book);
            copyDAO.save(copy);
        }
    }

    @Override
    public void addBookToAuthor(Book book) {
        if(book.getAuthor().getBooks() == null) {
            book.getAuthor().setBooks(new HashSet<Book>());
        }
        book.getAuthor().getBooks().add(book);
    }

    @Override
    public void updateBookById(Book book, Integer id) {
        Book oldBook = bookDAO.find(id);
        if(oldBook != null) {
            oldBook.setTitle(book.getTitle());
            oldBook.setEdition(book.getEdition());
            //oldBook.setCopyCount(book.getCopyCount());
            oldBook.setPages(book.getPages());
            oldBook.setYear(book.getYear());
            Author author = authorDAO.findAuthorByFullName(book.getAuthor().getFirstName(), book.getAuthor().getLastName());
            if(author == null) {
                authorDAO.deleteBookByID(oldBook.getAuthor(), oldBook.getIdBook());
                authorDAO.save(book.getAuthor());
            }
            oldBook.setAuthor(book.getAuthor());
            addBookToAuthor(oldBook);
            bookDAO.update(oldBook);
        }
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

    @Override
    public boolean removeAllCopies(Integer id) {
        boolean isAllInStock = true;
        List copies = copyDAO.getAllCopiesOfBook(id);
        for(Object copy: copies) {
            if(!((Copy)copy).getIsInStock()) {
                isAllInStock = false;
                break;
            }
        }
        if(isAllInStock) {
            for(Object copy: copies) {
                copyDAO.delete(((Copy)copy).getId());
            }
            Book book = bookDAO.find(id);
            authorDAO.deleteBookByID(book.getAuthor(), id);
            bookDAO.delete(id);
        }
        return isAllInStock;
    }
}
