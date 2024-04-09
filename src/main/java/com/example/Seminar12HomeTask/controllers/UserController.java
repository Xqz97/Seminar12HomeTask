package com.example.Seminar12HomeTask.controllers;

import com.example.Seminar12HomeTask.domain.User;
import com.example.Seminar12HomeTask.services.FileGateway;
import com.example.Seminar12HomeTask.services.NotificationService;
import com.example.Seminar12HomeTask.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.extern.slf4j.Slf4j;


/**
 * Класс UserController отвечает за обработку REST-точек доступа, связанных с добавлением пользователей разными способами и получением списка пользователей.
 *
 * @author Roman Turusov
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    private final FileGateway fileGateway;

    @Autowired
    private NotificationService notificationService;

    /**
     * Получить список пользователей.
     *
     * @return Список пользователей
     */
    @GetMapping
    public List<User> userList() {
        log.info("GET request received to fetch user list");
        return service.getDataProcessingService().getRepository().getUsers();
    }

    /**
     * Добавить пользователя из тела запроса.
     *
     * @param user Пользователь для добавления
     * @return Сообщение об успешном добавлении пользователя
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        log.info("POST request received to add user from body: {}", user);
        service.processRegistration(user.getName(), user.getAge(), user.getEmail());
        fileGateway.writeToFile(user.getName() + ".txt", user.toString());
        return "User added from body!";
    }

    /**
     * Получить список уведомлений.
     *
     * @return Список уведомлений
     */
    @GetMapping("/notifications")
    public List<String> getNotifications() {
        return notificationService.getNotifications();
    }

    /**
     * Добавить пользователя из параметров запроса.
     *
     * @param name Имя нового пользователя
     * @param email Email нового пользователя
     * @param age Возраст нового пользователя
     * @return Результат операции добавления пользователя
     */
    @PostMapping("/param")
    public String userAddFromParam(@RequestParam String name, @RequestParam String email, @RequestParam String age) {
        log.info("POST request received to add user from parameters - Name: {}, Email: {}, Age: {}", name, email, age);
        try {
            int ageValue = Integer.parseInt(age);
            User newUser = new User(name, ageValue, email);
            service.getDataProcessingService().getRepository().getUsers().add(newUser);
            return "User added from param!";
        } catch (NumberFormatException e) {
            log.error("Failed to add user: Age must be a valid integer!");
            return "Failed to add user: Age must be a valid integer!";
        }
    }
}