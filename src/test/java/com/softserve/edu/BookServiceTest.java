package com.softserve.edu;

import com.softserve.edu.dao.BookDAO;
import com.softserve.edu.entity.Author;
import com.softserve.edu.entity.Book;
import com.softserve.edu.service.impl.BookServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Mock
    private BookDAO bookDAO;

    @InjectMocks
    private BookServiceImpl bookService;

    @Spy
    private List<Book> books = new ArrayList<>();

    @BeforeClass
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        books = getListBooks();
    }

    @Test
    public void findById(){
        Book book = books.get(0);
        when(bookDAO.find(anyInt())).thenReturn(book);
        Assert.assertEquals(bookService.find(book.getIdBook()), book);
    }

    @Test
    public void findAllBooks() {
        when(bookDAO.findAll()).thenReturn(books);
        Assert.assertEquals(bookService.findAll(), books);
    }

    @Test
    public void testUpdateBookToExistingBook() {
        Book book = books.get(0);
        when(bookDAO.findBookByOtherBookProperties(book)).thenReturn(new Book());
        Assert.assertFalse(bookService.updateBookById(book, book.getIdBook()));
    }

    public List<Book> getListBooks() {
        Author author1 = new Author();
        author1.setFirstName("Макс");
        author1.setLastName("Кідрук");
        author1.setIdAuthor(1);
        author1.setBooks(new HashSet<>());
        Book book1 = new Book();
        book1.setIdBook(1);
        book1.setTitle("Бот");
        book1.setEdition("КСД");
        book1.setPages(412);
        book1.setCopyCount(2);
        book1.setYear(2014);
        book1.setAuthor(author1);
        author1.getBooks().add(book1);

        Book book2 = new Book();
        book1.setIdBook(2);
        book1.setTitle("Бот2");
        book1.setEdition("КСД");
        book1.setPages(575);
        book1.setCopyCount(5);
        book1.setYear(2015);
        book1.setAuthor(author1);
        author1.getBooks().add(book2);

        Author author2 = new Author();
        author2.setFirstName("Тарас");
        author2.setLastName("Шевченко");
        author2.setIdAuthor(2);
        author2.setBooks(new HashSet<>());

        Book book3 = new Book();
        book3.setIdBook(3);
        book3.setTitle("Кобзар");
        book3.setEdition("Світанок");
        book3.setPages(401);
        book3.setCopyCount(1);
        book3.setYear(2010);
        book3.setAuthor(author2);
        author2.getBooks().add(book3);

        Book book4 = new Book();
        book4.setIdBook(4);
        book4.setTitle("Українські народні пісні");
        book4.setEdition("Світанок");
        book4.setPages(120);
        book4.setCopyCount(10);
        book4.setYear(2010);
        book4.setAuthor(null);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        return books;
    }
}
