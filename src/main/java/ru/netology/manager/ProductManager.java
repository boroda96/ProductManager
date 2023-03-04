package ru.netology.manager;


import org.jetbrains.annotations.NotNull;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    public ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product item : repo.getItems()) {
            if (matches(item, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                    i++;

                }
                tmp[tmp.length - 1] = item;
                result = tmp;

            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return (product.getName().contains(search));


    }
}




