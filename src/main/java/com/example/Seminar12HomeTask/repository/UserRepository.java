package com.example.Seminar12HomeTask.repository;

import com.example.Seminar12HomeTask.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс UserRepository представляет репозиторий пользователей, хранящий список пользователей.
 * @author Roman Turusov
 */
@Component
public class UserRepository {
    private List<User> users = new ArrayList<>();

    /**
     * Получить список пользователей.
     *
     * @return Список пользователей
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Установить список пользователей.
     *
     * @param users Список пользователей
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Добавить пользователя в список.
     *
     * @param user Пользователь для добавления
     */
    public void addUser(User user) {
        users.add(user);
    }
}