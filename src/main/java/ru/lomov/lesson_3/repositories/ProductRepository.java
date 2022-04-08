package ru.lomov.lesson_3.repositories;

import ru.lomov.lesson_3.models.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    Product findById(Long id);
    void add(Product product);
}
