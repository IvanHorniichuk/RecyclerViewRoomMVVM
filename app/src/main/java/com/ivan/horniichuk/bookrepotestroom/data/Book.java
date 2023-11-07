package com.ivan.horniichuk.bookrepotestroom.data;

import java.util.Objects;

public class Book {
    private int id;
    private String title;
    private String author;
    private int pages;
    private String note;

    public Book() {
    }

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public Book(int id, String title, String author, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public Book(String title, String author, int pages, String note) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.note = note;
    }
    public Book(int id, String title, String author, int pages, String note) {
        this.id = id;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && pages == book.pages && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(note, book.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, pages, note);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", note='" + note + '\'' +
                '}';
    }
}
