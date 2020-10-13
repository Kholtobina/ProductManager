package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Product;
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
            if (product.matches(searchText)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}



