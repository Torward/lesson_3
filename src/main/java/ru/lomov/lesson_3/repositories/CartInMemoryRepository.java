package ru.lomov.lesson_3.repositories;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.lomov.lesson_3.models.Cart;
import ru.lomov.lesson_3.models.Product;

import javax.annotation.PostConstruct;
import java.util.*;


@Component
@Scope("prototype")
public class CartInMemoryRepository implements CartRepository {
    private Cart cart = new Cart();
    private List<Cart> carts;
    private Map<Cart,Product> products;
    private long index;

    @PostConstruct
    public void init() {
        products = new HashMap<>();
        carts = new ArrayList<>();
        index = 0L;
    }

    @Override
    public void addProduct(Product product) {
        products.put(cart, product);
        System.out.println(products.size());
        System.out.println(products.values());
    }


    @Override
    public void removeProductById(Long id) {
        Product product = Product.builder().id(id).build();
            products.remove(cart, product);
    }

    @Override
    public List<Product> showAllProduct() {
        return  Collections.unmodifiableList(products.values().stream().toList());
    }

    @Override
    public Cart findById(Long id) {
        return null;
    }

    @Override
    public Cart createNew() {
        cart.setId(++index);
        carts.add(cart);
        return cart;
    }

}
