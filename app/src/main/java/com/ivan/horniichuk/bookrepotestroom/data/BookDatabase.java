package com.ivan.horniichuk.bookrepotestroom.data;

import android.content.Context;

import androidx.room.Room;

import com.ivan.horniichuk.bookrepotestroom.basic.concurency.Fault;
import com.ivan.horniichuk.bookrepotestroom.basic.concurency.TaskCallback;
import com.ivan.horniichuk.bookrepotestroom.data.mappers.BookEntitiesListToBookList;
import com.ivan.horniichuk.bookrepotestroom.data.mappers.BookToBookEntityMapper;
import com.ivan.horniichuk.bookrepotestroom.data.room.AppDatabase;
import com.ivan.horniichuk.bookrepotestroom.data.room.BookDAO;
import com.ivan.horniichuk.bookrepotestroom.data.room.BookEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BookDatabase implements BookRepository {

    private final ExecutorService executorService;
    private final BookDAO bookDAO;

    private final BookToBookEntityMapper bookToBookEntityMapper = new BookToBookEntityMapper();
    private final BookEntitiesListToBookList bookEntitiesListToBookList = new BookEntitiesListToBookList();

    public BookDatabase(Context context) {
        AppDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "BookDB").build();
        executorService = Executors.newSingleThreadExecutor();
        bookDAO = db.getBookDAO();
    }

    @Override
    public void addNewBook(Book book,TaskCallback<Boolean> callback) {
        executorService.submit(() -> {
            try {
                bookDAO.insert(bookToBookEntityMapper.map(book));
                callback.onCompleted(true, null);
            }catch (Exception e){
                callback.onCompleted(false,new Fault(e));
            }
        });
    }

    @Override
    public void getAllBooks(TaskCallback<List<Book>> callback) {
        executorService.submit(() -> {
            try {
                List<BookEntity> books = bookDAO.getAll();
                callback.onCompleted(bookEntitiesListToBookList.map(books), null);
            }
            catch (Exception e)
            {
                callback.onCompleted(null,new Fault(e));
            }
        });
    }


}
