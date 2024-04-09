package com.example.Seminar12HomeTask.controllers;

import com.example.Seminar12HomeTask.domain.User;
import com.example.Seminar12HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
/**
 * Класс TaskController отвечает за обработку REST-точек доступа, связанных с задачами над списком пользователей.
 *
 * @author Roman Turusov
 */
public class TaskController {

    @Autowired
    private DataProcessingService service;

    /**
     * Получить список всех доступных задач.
     *
     * @return Список названий задач
     */
    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Сортировать пользователей по возрасту.
     *
     * @return Список отсортированных пользователей
     */
    @GetMapping("/sort")
    public List<User> sortUserByAge(){
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Фильтровать пользователей по возрасту.
     *
     * @param age Возраст, по которому нужно отфильтровать пользователей
     * @return Список отфильтрованных пользователей
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUserByAge(@PathVariable("age") int age){
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    /**
     * Вычислить средний возраст пользователей.
     *
     * @return Средний возраст пользователей
     */
    @GetMapping("/calc")
    public double calcAvgUserByAge(){
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
