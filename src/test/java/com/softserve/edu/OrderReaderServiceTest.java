package com.softserve.edu;

import com.softserve.edu.dao.OrderReaderDAO;
import com.softserve.edu.dao.ReaderDAO;
import com.softserve.edu.entity.*;
import com.softserve.edu.service.impl.OrderReaderServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Ruslan on 17.12.2015.
 */
public class OrderReaderServiceTest {

    @Mock
    private OrderReaderDAO orderReaderDAO;

    @Mock
    private ReaderDAO readerDAO;

    @InjectMocks
    private OrderReaderServiceImpl orderReaderService;

    @Spy
    private List<OrderReader> orderReaders = new ArrayList<>();
    private boolean isExist = false;

    @BeforeClass
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        orderReaders = getListOrders();

    }

    @Test
    public void testFindByIdOrder(){
        OrderReader orderReader = orderReaders.get(0);
        when(orderReaderDAO.find(anyInt())).thenReturn(orderReader);
        Assert.assertEquals(orderReaderService.find(orderReader.getIdOrder()), orderReader);
    }

    @Test
    public void testFindAllOrders() {
        when(orderReaderDAO.findAll()).thenReturn(orderReaders);
        Assert.assertEquals(orderReaderService.findAll(), orderReaders);
    }

    @Test
    public void testUpdateOrder() {
        OrderReader orderReader = orderReaders.get(1);
        when(orderReaderDAO.find(anyInt())).thenReturn(orderReader);
        orderReaderService.update(orderReader, orderReader.getIdOrder());
        verify(orderReaderDAO, atLeastOnce()).find(anyInt());
    }


    public List<OrderReader> getListOrders() {
        Reader reader1 = new Reader();
        reader1.setIdReader(1);
        reader1.setName("Руслан");
        reader1.setSurname("Башенський");
        reader1.setPhone("0962110866");
        reader1.setAdress("Львів");
        reader1.setDateOfCreate((Date.valueOf(LocalDate.now())));
        reader1.setBirth((Date.valueOf(LocalDate.now())));

        Reader reader2 = new Reader();
        reader2.setIdReader(2);
        reader2.setName("Петро");
        reader2.setSurname("Антонів");
        reader2.setPhone("09353246121");
        reader2.setAdress("Київ");
        reader2.setDateOfCreate((Date.valueOf(LocalDate.now())));
        reader2.setBirth((Date.valueOf(LocalDate.now())));


        Author author1 = new Author();
        author1.setFirstName("Макс");
        author1.setLastName("Кідрук");
        author1.setIdAuthor(1);
        author1.setBooks(new HashSet<>());

        Author author2 = new Author();
        author2.setFirstName("Тарас");
        author2.setLastName("Шевченко");
        author2.setIdAuthor(2);
        author2.setBooks(new HashSet<>());

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
        book2.setIdBook(2);
        book2.setTitle("Кобзар");
        book2.setEdition("Світанок");
        book2.setPages(401);
        book2.setCopyCount(1);
        book2.setYear(2010);
        book2.setAuthor(author2);
        author2.getBooks().add(book2);

        Copy copy1 = new Copy();
        copy1.setId(1);
        copy1.setIsInStock(Boolean.TRUE);
        copy1.setBook(book1);

        Copy copy2 = new Copy();
        copy2.setId(2);
        copy2.setIsInStock(Boolean.TRUE);
        copy2.setBook(book2);

        OrderReader orderReader1 = new OrderReader();
        orderReader1.setDataOrder(Date.valueOf(LocalDate.now()));
        orderReader1.setDataReturn(Date.valueOf(LocalDate.now()));
        orderReader1.setIdOrder(1);
        orderReader1.setCopy(copy1);
        orderReader1.setReader(reader1);


        OrderReader orderReader2 = new OrderReader();
        orderReader2.setDataOrder(Date.valueOf(LocalDate.now()));
        orderReader2.setDataReturn(Date.valueOf(LocalDate.now()));
        orderReader2.setIdOrder(2);
        orderReader2.setCopy(copy2);
        orderReader2.setReader(reader2);

        orderReaders.add(orderReader1);
        orderReaders.add(orderReader2);
        return orderReaders;
    }
}
