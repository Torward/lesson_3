package ru.lomov.lesson_3.repositories;


import lombok.Getter;
import ru.lomov.lesson_3.models.Cart;
import ru.lomov.lesson_3.models.Product;

import java.util.Collection;
import java.util.List;


public interface CartRepository {

     Cart findById(Long id);
     Cart createNew();
     List<Product> showAllProduct();
     void addProduct(Product product);
     void removeProductById(Long id);


}
