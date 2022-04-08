package ru.lomov.lesson_3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lomov.lesson_3.models.Cart;
import ru.lomov.lesson_3.models.Product;
import ru.lomov.lesson_3.repositories.CartRepository;

import java.util.Collection;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductsService productsService;
    List<Product> products;

    @Autowired
    public CartService(CartRepository cartRepository, ProductsService productsService, List<Product> productsInCart) {
        this.cartRepository = cartRepository;
        this.productsService = productsService;
    }

    public Cart showById(Long id){
        return cartRepository.findById(id);
    }

    public List<Product> showAllProductInCart(){
        return cartRepository.showAllProduct();
    }

    public void putProductInCart(Long id){
        Product product = productsService.findById(id);
        cartRepository.addProduct(product);
        System.out.println(this.getClass().getName() + " В корзину положен продукт с id = " + id);

    }

    public void deleteFromCartById(Long id){
        cartRepository.removeProductById(id);

    }
    public Cart createNewCart(){
        return cartRepository.createNew();

    }

}
