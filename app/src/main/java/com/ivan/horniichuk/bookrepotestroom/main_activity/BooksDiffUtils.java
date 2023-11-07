package com.ivan.horniichuk.bookrepotestroom.main_activity;

import androidx.recyclerview.widget.DiffUtil;

import com.ivan.horniichuk.bookrepotestroom.data.Book;

import java.util.List;

public class BooksDiffUtils extends DiffUtil.Callback{

    private final List<Book> oldList;
    private final List<Book> newList;

    public BooksDiffUtils(List<Book> oldList, List<Book> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Book oldBook=oldList.get(oldItemPosition);
        Book newBook=newList.get(newItemPosition);
        return oldBook.getId()==newBook.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Book oldBook=oldList.get(oldItemPosition);
        Book newBook=newList.get(newItemPosition);
        return oldBook.equals(newBook);
    }

}
