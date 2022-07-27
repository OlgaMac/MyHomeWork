package com.aston.library;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.System.*;

public class BookArrayList implements BookList {

    private Book[] array = new Book[10];
    private int size = 0;

    @Override
    public Book get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Book book) {
        increaseArray();
        array[size] = book;
        size++;

    }

    @Override
    public void add(int index, Book book) {
        increaseArray();
        checkIndex(index);
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = book;
        size++;

    }

    @Override
    public void set(int index, Book book) {
        checkIndex(index);
        array[index] = book;
    }

    @Override
    public boolean remove(Book book) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(book)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public int indexOf(Book book) {
        Objects.requireNonNull(book);
        for (int i = 0; i < size; i++) {
            if (array[i].equals(book)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Book[10];
        size = 0;

    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
}
