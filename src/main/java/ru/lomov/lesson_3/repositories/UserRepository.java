package ru.lomov.lesson_3.repositories;

import ru.lomov.lesson_3.models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findByUid(Long uId);
    String findPasswordByUid(Long uId);
    String findNicknameByEmailAndPassword(String email, String password);
    void addNew(User user);
}
