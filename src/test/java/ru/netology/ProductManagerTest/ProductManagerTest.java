package ru.netology.ProductManagerTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import ru.netology.manager.ProductManager;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Книга1", 100, "Пушкин");
    Product book2 = new Book(2, "Книга2", 200, "Толстой");
    Product book3 = new Book(3, "Книга3", 300, "Есенин");
    Product smart1 = new Smartphone(4, "Смарт1", 400, "Samsung");
    Product smart2 = new Smartphone(5, "Смарт2", 500, "Apple");
    Product smart3 = new Smartphone(6, "Смарт3", 601, "Nokia");

    @Test
    public void searchItem() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);

        String text = "Смарт1";

        Product[] expected = {smart1};
        Product[] actual = manager.searchBy(text);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchItemMon() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);

        String name = "Книга3";

        Product[] expected = {book3};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchItemNull() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);

        String name = "Книга4";

        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchItemAll() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);

        String text = "1";


        Product[] expected = {book1, smart1};
        Product[] actual = manager.searchBy(text);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void setManufacturer() {
        Smartphone tmp = new Smartphone(4, "Смарт1", 400, "Samsung");
        tmp.setManufacturer("Samsung");

        String expected = "Samsung";
        String actual = tmp.getManufacturer();

        Assertions.assertEquals(expected, actual);
    }


}
