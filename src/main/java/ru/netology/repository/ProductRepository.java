package ru.netology.repository;

import ru.netology.domain.Product;

import java.util.Arrays;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void saveProduct(Product addedProduct) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);

        int lastProductIndex = tmp.length - 1;
        tmp[lastProductIndex] = addedProduct;
        products = tmp;
    }

    public Product[] getAllProducts() {

        return products;
    }

    public void removeById(int idToRemove) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != idToRemove) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
}
