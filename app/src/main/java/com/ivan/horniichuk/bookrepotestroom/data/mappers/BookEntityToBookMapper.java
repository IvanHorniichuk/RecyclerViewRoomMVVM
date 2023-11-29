package com.ivan.horniichuk.bookrepotestroom.data.mappers;

import androidx.annotation.NonNull;

import com.ivan.horniichuk.bookrepotestroom.data.Book;
import com.ivan.horniichuk.bookrepotestroom.data.room.BookEntity;

public class BookEntityToBookMapper implements Mapper<BookEntity, Book> {
    @Override
    public Book map(@NonNull BookEntity val) {
        return new Book(val.getId(), val.getTitle(), val.getAuthor(), val.getPages(), val.getNote());
    }
}
