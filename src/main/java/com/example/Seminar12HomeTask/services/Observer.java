package com.example.Seminar12HomeTask.services;

import com.example.Seminar12HomeTask.domain.User;

/**
 * Интерфейс Observer определяет метод уведомления о добавлении пользователя.
 * @author Roman Turusov
 */
public interface Observer {

    /**
     * Уведомление об добавлении нового пользователя.
     *
     * @param user Новый пользователь
     */
    void notificationOfAddUser(User user);
}