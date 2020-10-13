package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone smartphone = new Smartphone();

    @Test
    public void shouldCheckMatchesByName() {
        Smartphone smartphone = new Smartphone(1, "IPhone 11", 52000, "Apple");
        String searchText = "iphone 11";

        assertEquals(true, smartphone.matches(searchText));
    }

    @Test
    public void shouldCheckMatchesByManufacturer() {
        Smartphone smartphone = new Smartphone(1, "IPhone 11", 52000, "Apple");
        String searchText = "APPLE";

        assertEquals(true, smartphone.matches(searchText));
    }

    @Test
    public void shouldCheckNotMatchesByName() {
        Smartphone smartphone = new Smartphone(1, "IPhone 11", 52000, "Apple");
        String searchText = "iphone 113456";

        assertEquals(false, smartphone.matches(searchText));
    }

    @Test
    public void shouldCheckNotMatchesByManufacturer() {
        Smartphone smartphone = new Smartphone(1, "IPhone 11", 52000, "Apple");
        String searchText = "APP";

        assertEquals(false, smartphone.matches(searchText));
    }
}