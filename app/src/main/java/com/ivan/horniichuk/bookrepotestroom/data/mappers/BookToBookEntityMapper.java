package com.ivan.horniichuk.bookrepotestroom.data.mappers;

import androidx.annotation.NonNull;

import com.ivan.horniichuk.bookrepotestroom.data.Book;
import com.ivan.horniichuk.bookrepotestroom.data.room.BookEntity;

public class BookToBookEntityMapper implements Mapper<Book, BookEntity> {
    @Override
    public BookEntity map(@NonNull Book val) {
        return new BookEntity(val.getTitle(),val.getAuthor(), val.getPages(),val.getNote());
    }
}
