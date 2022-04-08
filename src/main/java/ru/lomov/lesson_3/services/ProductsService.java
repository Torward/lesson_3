package ru.lomov.lesson_3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lomov.lesson_3.models.Product;
import ru.lomov.lesson_3.repositories.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> showAll(){
        return productsRepository.findAll();
    }

    public Product findById(Long id){
        return productsRepository.findById(id);
    }

    public void addToRepository(Product product){
        productsRepository.add(product);
    }

}
