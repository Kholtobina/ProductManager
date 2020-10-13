package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product = new Product();

    @Test
    public void shouldCheckMatchesByName() {

        Product product = new Product(1, "Product name", 1000);
        String searchText = "product NAME";

        assertEquals(true, product.matches(searchText));
    }

    @Test
    public void shouldCheckMatchesByName2() {

        Product product = new Product(1, "Product name 2.0", 1000);
        String searchText = "produCT NAME 2.0";

        assertEquals(true, product.matches(searchText));
    }

    @Test
    public void shouldCheckNotMatchesByName() {

        Product product = new Product(1, "name", 1000);
        String searchText = "productNAME";

        assertEquals(false, product.matches(searchText));
    }
}
