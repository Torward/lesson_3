package ru.lomov.lesson_3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lomov.lesson_3.models.User;
import ru.lomov.lesson_3.services.CartService;
import ru.lomov.lesson_3.services.UserService;

@Controller
@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
public class UserController {

    private final UserService userService;
    private final CartService cartService;



    public UserController(UserService userService, CartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }
    @PostMapping("/enter")
    public String logIn(@RequestParam String email, @RequestParam String password){
        if (email != null && password != null){
           userService.showNicknameByEmailAndPassword(email,password);
        }
        if (userService.isValid()){
            return "catalog";
        } else {
            return "registration_form";
        }
    }

    @PostMapping("/buy/{id}")
    public String putProductInCart(@PathVariable Long id){
        cartService.putProductInCart(id);
        System.out.println(this.getClass().getName() + "В корзину положен продукт с id = " + id);
        return "cart";
    }

    @PostMapping("/add_new_user")
    public String createNewUser(@RequestParam String nickname, @RequestParam String email, @RequestParam String password){
        if (nickname != null & email != null & password != null){
            User user = new User(nickname, email, password);
            userService.addNew(user);
        } else{
            return "registration_form";
        }
        return "redirect:/catalog";
    }
    //-----------------------------------------
    // Ссылка на переход на форму входа
    @GetMapping("/login_form")
    public String showLoginForm(){
        return "login_form";
    }
    // Ссылка на переход на форму регистрации
    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "registration_form";
    }


}
