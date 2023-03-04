package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;

public class ProductRepository {
    Product[] items = new Product[0];

    public void save(Product item) {
        if (findById(item.getId()) != null) {
            throw new AlreadyExistsException(item.getId() +
                    " - ID уже существует!!!");

        }
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];

        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] getItems() {
        return items.clone();
    }


    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(id +
                    " - ID не найден!!!");

        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;

    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;

            }

        }
        return null;
    }


}
