package com.example.Seminar12HomeTask.services;

import com.example.Seminar12HomeTask.domain.User;
import com.example.Seminar12HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис DataProcessingService предоставляет методы для обработки данных пользователей.
 * @author  Roman Turusov
 */
@Service
public class DataProcessingService {

    @Autowired
    private UserRepository repository;

    /**
     * Получить репозиторий пользователей.
     *
     * @return Репозиторий пользователей
     */
    public UserRepository getRepository() {
        return repository;
    }

    /**
     * Сортировка пользователей по возрасту.
     *
     * @param users Список пользователей
     * @return Отсортированный список пользователей по возрасту
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Фильтрация пользователей по возрасту.
     *
     * @param users Список пользователей
     * @param age Возраст для фильтрации
     * @return Список пользователей старше заданного возраста
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Вычисление среднего возраста пользователей.
     *
     * @param users Список пользователей
     * @return Средний возраст пользователей или 0, если список пуст
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Добавить пользователя в список пользователей репозитория.
     *
     * @param user Пользователь для добавления
     */
    public void addUserToList(User user) {
        repository.getUsers().add(user);
    }
}

