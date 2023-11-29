package com.ivan.horniichuk.bookrepotestroom.data;

import com.ivan.horniichuk.bookrepotestroom.basic.concurency.TaskCallback;

import java.util.List;

public interface BookRepository {
    void addNewBook(Book book,TaskCallback<Boolean> callback);

    void getAllBooks(TaskCallback<List<Book>> callback);
}
