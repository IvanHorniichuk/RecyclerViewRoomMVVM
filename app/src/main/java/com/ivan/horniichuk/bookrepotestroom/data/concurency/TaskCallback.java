package com.ivan.horniichuk.bookrepotestroom.data.concurency;

@FunctionalInterface
public interface TaskCallback<T> {
    void onCompleted(T result, Fault fault);
}