package ru.lomov.lesson_3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lomov.lesson_3.models.Product;
import ru.lomov.lesson_3.services.ProductsService;
import ru.lomov.lesson_3.services.UserService;

@Controller
@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
public class ProductController {

    private final ProductsService productsService;
    private final UserService userService;

    public ProductController(ProductsService productsService, UserService userService) {
        this.productsService = productsService;
        this.userService = userService;
    }

    @GetMapping("/catalog")
    public String findAll(Model model){
        if(userService.isValid()){
            model.addAttribute("products", productsService.showAll());
            return "catalog";
        } else {
            return "login_form";
        }
    }

    @PostMapping("/search")
    public String search(@RequestParam Long id, Model model){
       model.addAttribute("product", productsService.findById(id));
        return "product";
    }

    @GetMapping("/add")
    public String showAddForm(){
        return "add_form";
    }

    @PostMapping("/create")
    public String createNewProduct(@RequestParam String title, @RequestParam int price){
        Product product = new Product(title, price);
        productsService.addToRepository(product);
        return "redirect:/catalog";
    }

}
