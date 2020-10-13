package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

@NoArgsConstructor
@AllArgsConstructor

public class ProductManager {
    private ProductRepository repository;

    public void addProduct(Product addedProduct) {
        repository.saveProduct(addedProduct);
    }

    public Product[] searchBy(String searchText) {
        Product[] result = new Product[0];
        for (Product product : repository.getAllProducts()) {
            if (matches(product, searchText)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String searchText) {

        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(searchText)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(searchText)) {
                return true;
            }
        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(searchText)) {
                return true;
            }
            if (smartphone.getManufacturer().equalsIgnoreCase(searchText)) {
                return true;
            }
        }
        return false;
    }
}



