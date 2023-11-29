package com.ivan.horniichuk.bookrepotestroom.data.mappers;

import static org.junit.Assert.*;

import com.ivan.horniichuk.bookrepotestroom.data.Book;
import com.ivan.horniichuk.bookrepotestroom.data.BookRepository;
import com.ivan.horniichuk.bookrepotestroom.data.room.BookEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookToBookEntityMapperTest {

    private BookToBookEntityMapper mapper;
    @Before
    public void setUp() throws Exception {
        mapper=new BookToBookEntityMapper();
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
        Book book=new Book(1,"Title","author",100,"note");
        assertNotNull(mapper.map(book));
    }
}