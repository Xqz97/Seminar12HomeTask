package com.example.Seminar3HomeTask.services;

import com.example.Seminar3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private UserService userService;
    private NotificationService notificationService;

    public RegistrationService(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;


    //Метод processRegistration
    public void processRegistration(String name, int age, String email){
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
    }

}
