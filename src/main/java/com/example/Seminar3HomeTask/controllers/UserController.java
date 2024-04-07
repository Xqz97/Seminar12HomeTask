package com.example.Seminar3HomeTask.controllers;

import com.example.Seminar3HomeTask.domain.User;
import com.example.Seminar3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }

    @PostMapping("/param")
    public String userAddFromParam(@RequestParam String name, @RequestParam String email, @RequestParam String age) {
        try {
            int ageValue = Integer.parseInt(age);
            User newUser = new User(name, ageValue, email);
            service.getDataProcessingService().getRepository().getUsers().add(newUser);
            return "User added from param!";
        } catch (NumberFormatException e) {
            return "Failed to add user: Age must be a valid integer!";
        }
    }
}
