package ru.itmo.lessons.questions.question1;

public class User implements IUser, IAuthorization{

    // реализация абстрактных методов
    @Override
    public String getToken() {
        return null;
    }

    @Override
    public void enterInfo() {
        System.out.println("Пользователь авторизован");
    }

    @Override
    public String getUserName() {
        return null;
    }

    public static void main(String[] args) {
        User user = new User();
        user.enterInfo();
    }
}