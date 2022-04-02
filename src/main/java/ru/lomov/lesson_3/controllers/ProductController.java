package ru.lomov.lesson_3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lomov.lesson_3.models.Product;
import ru.lomov.lesson_3.services.ProductsService;

@Controller
public class ProductController {

    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/catalog")
    public String findAll(Model model){
        model.addAttribute("products", productsService.showAll());
        return "catalog";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        return "add_form";
    }

    @PostMapping("/create")
    public String createNewProduct(@RequestParam String title, @RequestParam int price){
        Product product = new Product(title, price);
        productsService.addToRepository(product);
        return "redirect:/catalog";
    }
}
