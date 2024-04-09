package com.example.Seminar12HomeTask.services;

import com.example.Seminar12HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис регистрации пользователей.
 * @author Roman Turusov
 */
@Service
public class RegistrationService {

    private UserService userService;
    private NotificationService notificationService;

    /**
     * Конструктор сервиса регистрации с инъекцией зависимостей.
     *
     * @param userService Сервис пользователей
     * @param notificationService Сервис уведомлений
     */
    public RegistrationService(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    /**
     * Получить сервис обработки данных.
     *
     * @return Сервис обработки данных
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    /**
     * Обработка регистрации нового пользователя.
     *
     * @param name Имя пользователя
     * @param age Возраст пользователя
     * @param email Email пользователя
     */
    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.notifyObservers(user);
    }
}
