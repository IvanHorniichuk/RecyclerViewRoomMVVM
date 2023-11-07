package com.ivan.horniichuk.bookrepotestroom.data.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Books",
        indices = {
                @Index("Id"),
        })
public class BookEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;
    @ColumnInfo(name = "Title")
    private String title;
    @ColumnInfo(name = "Author")
    private String author;
    @ColumnInfo(name = "PagesNumber")
    private int pages;
    @ColumnInfo(name = "Note")
    private String note;

    public BookEntity() {
    }

    @Ignore
    public BookEntity(String title, String author, int pages, String note) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.note = note;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

