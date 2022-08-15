package com.aston.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookListTest {

    private BookList bookList;

    @BeforeEach
    public void setUp() {
        // init
        bookList = new BookArrayList();
        bookList.add(new Book("Effective Java", "Joshua Bloch"));
        bookList.add(new Book("Java: A Beginner's Guide", "Hebert Schildt"));
        bookList.add(new Book("Java The Complete Reference", "Hebert Schildt"));
        bookList.add(new Book("Head First Java", "Kathy Sierra & Bert Bates"));
        bookList.add(new Book("Java Concurrency in Practice", "Brien Goetz with Tim Peierls, Joshua Bloch"));
        bookList.add(new Book("Test-Driven: TDD", "Lasse Koskela"));
        bookList.add(new Book("Clean Code", "Robert Cecil Martin"));
        bookList.add(new Book("Java 8 in Action", "Alan Mycroft"));
        bookList.add(new Book("Thinking in Java", "Bruce Eckel"));
        bookList.add(new Book("Spring in Action", "Craig Walls"));

    }

    @Test
    public void methodGetReturnRightValue() {
        Book book = bookList.get(1);
        assertEquals("Java: A Beginner's Guide", book.getName());
    }

    @Test
    public void whenAdded10ElementsThenSizeMustBe10() {
        assertEquals(10, bookList.size());
    }

    @Test
    public void testAddByIndexIntoMiddle() {
        Book book = new Book("Война и Мир", "Лев Толстой");
        bookList.add(5, book);
        Book bookFromList = bookList.get(5);
        assertTrue(book.equals(bookFromList));
        assertEquals(11, bookList.size());
    }


    @Test
    public void testAddByIndexIntoFirstPosition() {
        Book book = new Book("Война и Мир", "Лев Толстой");
        bookList.add(0, book);
        Book bookFromList = bookList.get(0);
        assertTrue(book.equals(bookFromList));
        assertEquals(11, bookList.size());
    }

    @Test
    void testAddByIndexIntoLastPosition() {
        Book book = new Book("Война и Мир", "Лев Толстой");
        bookList.add(10, book);
        Book bookFromList = bookList.get(10);
        assertTrue(book.equals(bookFromList));
        assertEquals(11, bookList.size());
    }

    @Test
    public void methodSetReturnRightValue() {
        bookList.set(2, new Book("Война и Мир", "Лев Толстой"));
        assertEquals("Война и Мир", bookList.get(2).getName());
        assertEquals(10, bookList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Book book = new Book("Война и Мир", "Лев Толстой");
        bookList.add(book);
        assertEquals(11, bookList.size());
        assertTrue(bookList.remove(book));
        assertEquals(10, bookList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Book book = new Book("Война и Мир", "Лев Толстой");
        assertFalse(bookList.remove(book));
        assertEquals(10, bookList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(bookList.removeAt(9));
        assertEquals(9, bookList.size());
    }

    @Test
    public void testIndexOfMethod() {
        Book book = bookList.get(5);
        int index = bookList.indexOf(book);
        assertEquals(5, index);
    }

    @Test
    public void whenListIsEmptyThenReturnTrue() {
        assertFalse(bookList.isEmpty());
        bookList.clear();
        assertTrue(bookList.isEmpty());
    }


    @Test
    public void whenListClearedThenSizeMustBe0() {
        bookList.clear();
        assertEquals(0, bookList.size());
    }

    @Test
    public void whenIndexOutOfBoundsThenThrownException() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    bookList.get(10);
                });

    }
}