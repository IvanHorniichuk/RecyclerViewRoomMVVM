package com.ivan.horniichuk.bookrepotestroom.data.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ivan.horniichuk.bookrepotestroom.data.Book;

import java.util.List;


@Dao
public interface BookDAO {
    @Query("SELECT * FROM Books")
    List<BookEntity> getAll();

    @Insert
    void insert(BookEntity book);

}

