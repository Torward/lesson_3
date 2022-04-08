package ru.lomov.lesson_3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.lomov.lesson_3.services.CartService;
import ru.lomov.lesson_3.services.UserService;

@Controller
@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
public class CartController {

    private final UserService userService;
    private final CartService cartService;

    public CartController(UserService userService, CartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }
    @PostMapping("/cart")
    public String showAll(Model model){
        model.addAttribute("purchases", cartService.showAllProductInCart());
        return "cart";
    }
}
