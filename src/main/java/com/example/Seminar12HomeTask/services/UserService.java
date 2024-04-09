package com.example.Seminar12HomeTask.services;

import com.example.Seminar12HomeTask.domain.User;
import org.springframework.stereotype.Service;

/**
 * Сервис пользователей.
 * @author Roman turusov
 */
@Service
public class UserService {

    private NotificationService notificationService;

    /**
     * Конструктор сервиса пользователей с инъекцией сервиса уведомлений.
     *
     * @param notificationService Сервис уведомлений
     */
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Создание нового пользователя.
     *
     * @param name Имя пользователя
     * @param age Возраст пользователя
     * @param email Email пользователя
     * @return Созданный пользователь
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        return user;
    }
}
