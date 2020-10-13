package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class ProductManagerTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductManager productManager;

    private Book firstBook = new Book(1, "The Dark Tower", 500, "Stephen King");
    private Book secondBook = new Book(2, "Solaris", 700, "Stanislaw Lem");
    private Book thirdBook = new Book(3, "The Dark Tower II", 800, "Stephen King");
    private Smartphone firstPhone = new Smartphone(4, "IPhone 11", 52000, "Apple");
    private Smartphone secondPhone = new Smartphone(5, "Samsung Galaxy", 58000, "Samsung");
    private Smartphone thirdPhone = new Smartphone(6, "IPhone 7", 25000, "Apple");


    @Test
    public void shouldFindBookByAuthorWithIgnoredCase() {

        String searchText = "Stephen KING";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();


        Product[] expected = new Product[]{firstBook, thirdBook};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByNameWithIgnoredCase() {
        String searchText = "SOLARIS";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();

        Product[] expected = new Product[]{secondBook};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindBookByNameWithIgnoredCase2() {
        String searchText = "dark";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();

        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindSmartphoneByNameWithIgnoredCase() {
        String searchText = "iphonE 7";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();

        Product[] expected = new Product[]{thirdPhone};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllSmartphonesWithIgnoredCase2() {
        String searchText = "apple";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();

        Product[] expected = new Product[]{firstPhone, thirdPhone};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByManufacturerWithIgnoredCase() {
        String searchText = "SaMsUnG";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();

        Product[] expected = new Product[]{secondPhone};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNotFindProductWithIgnoredCase() {
        String searchText = "lem";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();

        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }
}