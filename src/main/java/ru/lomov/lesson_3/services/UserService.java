package ru.lomov.lesson_3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lomov.lesson_3.models.Cart;
import ru.lomov.lesson_3.models.User;
import ru.lomov.lesson_3.repositories.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CartService cartService;
    private boolean isValid = false;
    private Map<User, Cart> customers = new HashMap<>();

    @Autowired
    public UserService(UserRepository userRepository, CartService cartService) {
        this.userRepository = userRepository;
        this.cartService = cartService;
    }

    public List<User> showAll(){
        return userRepository.findAll();
    }

    public User showByUid(Long uId){
        return userRepository.findByUid(uId);
    }

    public String showPasswordByUid(Long uId){
        return userRepository.findPasswordByUid(uId);
    }

    public String showNicknameByEmailAndPassword(String email, String password){
        if (userRepository.findNicknameByEmailAndPassword(email, password) != null){
            isValid = true;
            return userRepository.findNicknameByEmailAndPassword(email, password);

        }else {
            return null;
        }
    }

    public void addNew(User user){
        userRepository.addNew(user);
        customers.put(user, cartService.createNewCart());
        isValid = true;
    }

    public boolean isValid() {
        return isValid;
    }
}
