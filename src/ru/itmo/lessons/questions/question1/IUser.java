package ru.itmo.lessons.questions.question1;

public interface IUser {
    default void enterInfo() {
        System.out.println("Пользователь авторизован");
    }
    String getUserName();
}