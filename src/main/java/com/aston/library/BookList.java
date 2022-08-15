package com.aston.library;


public interface BookList {
    Book get(int index);
    void add(Book book);
    void add(int index, Book book);
    void set(int index, Book book);
    boolean remove(Book book);
    boolean removeAt(int index);
    int indexOf(Book book);
    boolean isEmpty();
    int size();
    void clear();
}
