package com.example.Seminar3HomeTask.controllers;

import com.example.Seminar3HomeTask.domain.User;
import com.example.Seminar3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("cals");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUserByAge(){
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    //filterUsersByAge
    @GetMapping("/filter/{age}")
    public List<User> filterUserByAge(@PathVariable int age){
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    //calculateAverageAge
    @GetMapping("/calc")
    public double calcAvgUserByAge(){
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
