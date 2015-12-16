package com.softserve.edu;


import com.softserve.edu.dao.ReaderDAO;
import com.softserve.edu.entity.Reader;
import com.softserve.edu.service.impl.ReaderServiceImpl;
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
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class ReaderServiceTest {
    @Mock
    ReaderDAO readerDAO;

    @InjectMocks
    ReaderServiceImpl readerService;

    @Spy
    List<Reader> readers = new ArrayList<Reader>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        readers = getReaderList();
    }

    @Test
    public void testUpdateReader() {
        Reader reader = readers.get(0);
        when(readerDAO.find(anyInt())).thenReturn(reader);
        readerService.update(reader, reader.getIdReader());
        verify(readerDAO, atLeastOnce()).find(anyInt());
    }

    @Test
    public void testFindById() {
        Reader reader = readers.get(0);
        when(readerDAO.find(anyInt())).thenReturn(reader);
        Assert.assertEquals(readerService.findById(reader.getIdReader()), reader);
    }

    @Test
    public void testFindAllReaders(){
        when(readerDAO.findAll()).thenReturn(readers);
        Assert.assertEquals(readerService.findAll(), readers);
    }

    public List<Reader> getReaderList(){
        Reader r1 = new Reader();
        r1.setIdReader(1);
        r1.setName("Ihor");
        r1.setSurname("Sokolyk");
        r1.setPhone("09654245851");
        r1.setAdress("Lviv");
        r1.setDateOfCreate((Date.valueOf(LocalDate.now())));
        r1.setBirth((Date.valueOf(LocalDate.now())));

        Reader r2 = new Reader();
        r2.setIdReader(2);
        r2.setName("Bohdan");
        r2.setSurname("Smachylo");
        r2.setPhone("09654245121");
        r2.setAdress("Lviv");
        r2.setDateOfCreate((Date.valueOf(LocalDate.now())));
        r2.setBirth((Date.valueOf(LocalDate.now())));


        readers.add(r1);
        readers.add(r2);
        return readers;
    }
    }
