package com.ivan.horniichuk.bookrepotestroom.data.mappers;

public interface Mapper<I,O> {
    O map(I value);
}
