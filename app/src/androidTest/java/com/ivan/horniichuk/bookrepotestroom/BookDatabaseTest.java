package com.ivan.horniichuk.bookrepotestroom;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import com.ivan.horniichuk.bookrepotestroom.basic.concurency.Fault;
import com.ivan.horniichuk.bookrepotestroom.basic.concurency.TaskCallback;
import com.ivan.horniichuk.bookrepotestroom.data.Book;
import com.ivan.horniichuk.bookrepotestroom.data.BookDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(MockitoJUnitRunner.class)
public class BookDatabaseTest {

    private BookDatabase database;

    private Context contextMock;
    private TaskCallback callbackMock;

    private final CountDownLatch latch = new CountDownLatch(1);

    @Before
    public void setUp() throws Exception {
        contextMock = InstrumentationRegistry.getInstrumentation().getTargetContext();
        callbackMock = Mockito.mock(TaskCallback.class);
        database = new BookDatabase(contextMock);
    }

    @After
    public void tearDown() throws Exception {
        contextMock = null;
        callbackMock = null;
        database = null;
    }

    @Test
    public void successInit(){
        assertNotNull(database);
    }

    @Test
    public void getAllBooks() throws InterruptedException {
        List<Book> list=new ArrayList<>();
        database.getAllBooks(callbackMock);
        latch.await(500, TimeUnit.MILLISECONDS);
        verify(callbackMock).onCompleted(list,null);
        assertNotNull(list);
    }
    @Test
    public void addNewBook() throws InterruptedException {
        Book book=Mockito.mock(Book.class);
        database.addNewBook(book,callbackMock);
        latch.await(500, TimeUnit.MILLISECONDS);
        verify(callbackMock).onCompleted(true,null);
    }

    @Test
    public void addNewBookWithNullObject() throws InterruptedException {
        database.addNewBook(null, new TaskCallback<Boolean>() {
            @Override
            public void onCompleted(Boolean result, Fault fault) {
                assertNotNull(fault);
                assertFalse(result);
            }
        });

    }

}