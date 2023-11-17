package com.ivan.horniichuk.bookrepotestroom.basics.concurency;

@FunctionalInterface
public interface TaskCallback<T> {
    void onCompleted(T result, Fault fault);
}