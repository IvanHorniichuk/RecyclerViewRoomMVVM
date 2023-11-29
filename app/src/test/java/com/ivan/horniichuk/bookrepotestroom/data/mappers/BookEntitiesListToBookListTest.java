package com.ivan.horniichuk.bookrepotestroom.data.mappers;

import static org.junit.Assert.*;

import com.ivan.horniichuk.bookrepotestroom.data.room.BookEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class BookEntitiesListToBookListTest {

    private BookEntitiesListToBookList mapper;

    @Before
    public void setUp() throws Exception {
        mapper = new BookEntitiesListToBookList();
    }

    @After
    public void tearDown() throws Exception {
        mapper = null;
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
    public void mapEmptyList() {
        List<BookEntity> mockArrayList=new ArrayList<>();
        assertTrue(mapper.map(mockArrayList).isEmpty());
    }
    @Test
    public void map() {
        List<BookEntity> mockArrayList=new ArrayList<>();
        mockArrayList.add(Mockito.mock(BookEntity.class));
        mockArrayList.add(Mockito.mock(BookEntity.class));
        mockArrayList.add(Mockito.mock(BookEntity.class));
        assertNotNull(mapper.map(mockArrayList));
    }
}