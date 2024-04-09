package com.example.Seminar12HomeTask.services;

import com.example.Seminar12HomeTask.domain.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис уведомлений, реализующий интерфейс Observer.
 * @author Roman Turusov
 */
@Service
public class NotificationService implements Observer {

    private final List<Observer> observers = new ArrayList<>();
    private final List<User> userList = new ArrayList<>();
    private final List<String> notifications = new ArrayList<>();

    /**
     * Регистрация наблюдателя.
     *
     * @param observer Наблюдатель для регистрации
     */
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Оповещение наблюдателей о добавлении нового пользователя.
     *
     * @param user Новый пользователь
     */
    public void notifyObservers(User user) {
        for (Observer observer : observers) {
            observer.notificationOfAddUser(user);
        }
        userList.add(user);
        notifications.add("New user added: " + user.getName()); // Добавляем уведомление о новом пользователе
    }

    /**
     * Получение списка уведомлений.
     *
     * @return Список уведомлений
     */
    public List<String> getNotifications() {
        return notifications;
    }

    @Override
    public void notificationOfAddUser(User user) {
        System.out.println("Received notification of new user added: " + user.getName());
    }
}
