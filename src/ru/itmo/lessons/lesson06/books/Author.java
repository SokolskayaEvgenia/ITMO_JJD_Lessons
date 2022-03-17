package ru.itmo.lessons.lesson06.books;

public class Author {
    //свойства, характеристики, поля
    public String name; //null
    public String surname; //null
    // модификатор доступа public - можно обратиться из любого места программы

    // методы - возможности объектов, как они взаимодействуют с другими объектами

    //объявление методов
    public void printFullName() {
        // можно использовать "return;", чтобы прервать работу метода
        System.out.println(name + " " + surname);
    }

    public String getFullName() {
        //возвращает результат работы метода
        //прерывает работу метода, инструкции после return не будут выполнены
        return name + " " + surname;
    }
}
