package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book();

    @Test
    public void shouldCheckMatchesByName() {
        Book book = new Book(1, "SOLARIS", 100, "Stanislaw LEM");
        String searchText = "solaris";

        assertEquals(true, book.matches(searchText));
    }

    @Test
    public void shouldCheckMatchesByAuthor() {
        Book book = new Book(1, "Solaris", 100, "Stanislaw LEM");
        String searchText = "stanislaw lem";

        assertEquals(true, book.matches(searchText));
    }

    @Test
    public void shouldCheckNotMatchesByName() {
        Book book = new Book(1, "Solaris", 100, "Stanislaw LEM");
        String searchText = "solaris SOLARIS";

        assertEquals(false, book.matches(searchText));
    }

    @Test
    public void shouldCheckNotMatchesByAuthor() {
        Book book = new Book(1, "Solaris", 100, "Stanislaw LEM");
        String searchText = "Stanislawwww Lemmmm";

        assertEquals(false, book.matches(searchText));
    }
}