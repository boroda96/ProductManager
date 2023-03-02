package ru.netology.ProductRepositoryTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;



public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product book1 = new Book(1, "Книга 1", 100, "Пушкин");
    Product book2 = new Book(2, "Книга 2", 200, "Толстой");
    Product book3 = new Book(3, "Книга 3", 300, "Есенин");
    Product smart1 = new Smartphone(4, "Смарт 1", 400, "Samsung");
    Product smart2 = new Smartphone(5, "Смарт 2", 500, "Apple");
    Product smart3 = new Smartphone(6, "Смарт 3", 601, "Nokia");

    @BeforeEach
    public void setup() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smart1);
        repo.save(smart2);
        repo.save(smart3);
    }

    @Test
    public void saveAll() {


        Product[] expected = {book1, book2, book3, smart1, smart2, smart3};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById2() {

        repo.removeById(book2.getId());

        Product[] expected = {book1, book3, smart1, smart2, smart3};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeByIdAll() {
        repo.removeById(book1.getId());
        repo.removeById(book2.getId());
        repo.removeById(book3.getId());
        repo.removeById(smart1.getId());
        repo.removeById(smart2.getId());
        repo.removeById(smart3.getId());
        Product[] expected = {};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void setPrice() {
        Book tmp = new Book(3, "Книга 3", 300, "Есенин");
        tmp.setPrice(300);

        int expected = 300;
        int actual = tmp.getPrice();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void setAuthor() {
        Book tmp = new Book(3, "Книга 3", 300, "Есенин");
        tmp.setAuthor("Есенин");

        String expected = "Есенин";
        String actual = tmp.getAuthor();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void save1() {
        Product book4 = new Book(4, "Книга 4", 350, "Сталин");

        repo.save(book4);

        Product[] expected = {book1, book2, book3, smart1, smart2, smart3, book4};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }



}


