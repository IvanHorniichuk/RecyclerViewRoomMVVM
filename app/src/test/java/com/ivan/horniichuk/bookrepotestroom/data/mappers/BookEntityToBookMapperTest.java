package com.ivan.horniichuk.bookrepotestroom.data.mappers;

import static org.junit.Assert.*;

import com.ivan.horniichuk.bookrepotestroom.data.Book;
import com.ivan.horniichuk.bookrepotestroom.data.room.BookEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookEntityToBookMapperTest {

    private BookEntityToBookMapper mapper;
    @Before
    public void setUp() throws Exception {
        mapper=new BookEntityToBookMapper();
    }

    @After
    public void tearDown() throws Exception {
        mapper=null;
    }

    @Test
    public void initSuccess(){
        assertNotNull(mapper);
    }

    @Test(expected = NullPointerException.class)
    public void assertNullParameter(){
        assertNotNull(mapper.map(null));
    }

    @Test
    public void map() {
        BookEntity book=new BookEntity("Title","author",100,"note");
        assertNotNull(mapper.map(book));
    }
}