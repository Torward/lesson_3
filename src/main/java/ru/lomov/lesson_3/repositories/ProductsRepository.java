package ru.lomov.lesson_3.repositories;

import org.springframework.stereotype.Component;
import ru.lomov.lesson_3.models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component("ProductsRepository")
public class ProductsRepository implements ProductRepository {
    private List<Product> products;
    private long index = 6L;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product("milk", 1L, 120),
                new Product("bread", 2L, 82),
                new Product("vine", 3L, 1250),
                new Product("cheese", 4L, 1300),
                new Product("potato", 5L, 86),
                new Product("onion", 6L, 110)
        ));
    }

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }

    @Override
    public void add(Product product) {
        product.setId(++index);
        products.add(product);
    }
}
