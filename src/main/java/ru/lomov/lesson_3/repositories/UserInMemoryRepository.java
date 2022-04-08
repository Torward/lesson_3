package ru.lomov.lesson_3.repositories;

import org.springframework.stereotype.Component;
import ru.lomov.lesson_3.models.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserInMemoryRepository implements UserRepository{
    private List<User> users;
    private long index;

    @PostConstruct
    public void init(){
        users = new ArrayList<>();
        index = 0L;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findByUid(Long uId) {
        return users.stream().filter(i -> i.getUId().equals(uId)).findFirst().get();
    }

    @Override
    public String findPasswordByUid(Long uId) {
        String password = null;
        for (User user: users){
            if (uId.equals(user.getUId())){
                password = user.getPassword();
            }else{
                System.out.println("Неверные данные");
            }
        }
        return password;
    }


    @Override
    public String findNicknameByEmailAndPassword(String email, String password) {
        String nickname = null;
        for (User user: users){
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())){
                nickname = user.getNickname();
            }else{
                System.out.println("Неверные данные");
                return null;
            }
        }
        return nickname;
    }

    @Override
    public void addNew(User user) {
        user.setUId(++index);
        users.add(user);
    }
}
