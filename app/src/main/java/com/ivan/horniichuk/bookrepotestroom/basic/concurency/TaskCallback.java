package com.ivan.horniichuk.bookrepotestroom.basic.concurency;

@FunctionalInterface
public interface TaskCallback<T> {
    void onCompleted(T result, Fault fault);
}