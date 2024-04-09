package com.example.Seminar12HomeTask.domain;

/**
 * Класс User представляет собой модель пользователя с полями имя, возраст и email.
 * @author Roman Turusov
 */
public class User {
    private String name;
    private int age;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Конструктор по умолчанию класса User.
     */
    public User() {
    }

    /**
     * Конструктор с параметрами класса User.
     *
     * @param name Имя пользователя
     * @param age Возраст пользователя
     * @param email Email пользователя
     */
    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    /**
     * Представление объекта User в виде строки.
     *
     * @return Строковое представление объекта User
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}