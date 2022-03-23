package ru.itmo.lessons.lesson06;

//класс Application находится в пакете ru.itmo.lessons.lesson06
//полное имя класса: имя пакета + имя класса
//ru.itmo.lessons.lesson06.Application

import ru.itmo.lessons.lesson06.books.Author;
import ru.itmo.lessons.lesson06.books.Book;
import ru.itmo.lessons.lesson06.books.Shelf;

public class Application {
    /*класс - способ описания сущности, определяющий ее состояние и поведение
     класс - набор свойств и методов будущих объектов.

     На соснове класса создаются объекты (экземпляры данного класса)
     - представители данного класса, имеющие конкретное состояние и поведение,
     определенное в классе*/

    public static void main(String[] args) {
        Author author1 = new Author(); // ссылка author1 ссылается на экземпляр класса Author
        Author author2 = new Author();
        //обращение к свойствам осуществляется через точку
        // но при таком подходе в значение свойства можно записать все, что угодно.
        // Это может навредить программе
        // Например, author1.name = ""; или author1.surname = null; и тд
        // поэтому лучше ограничить свободный доступ к свойствам и
        // использовать методы, в которых можно будет реализовать проверку входящих данных
        author1.name = "Федор";
        author1.surname = "Достоевский";
        author2.name = "Лев";
        author2.surname = "Толстой";
        // вызов методов
        author1.printFullName();
        author2.printFullName();
        System.out.println(author1.getFullName());
        System.out.println(author2.getFullName());

        // типДанных имяПеременной = new вызовКонструктора(аргументы);
        Book book1 = new Book(author1); //создание объекта - вызов конструктора
        book1.setTitle("Книга");// от 3 символов
        System.out.println(book1.getTitle());
        book1.setPages(22);

        Book book2 = new Book(author2);
        book2.setTitle("Java 17");
        book2.setPages(3700);

        Book book3 = new Book(author1);
        book3.setTitle("Строки в Java");
        book3.setPages(1200);

        Book book4 = new Book(author1);
        book4.setTitle("Коллекции в Java");
        book4.setPages(300);

        Book book5 = new Book(author2);
        book5.setTitle("Многопоточность в Java");
        book5.setPages(2600);

        Shelf shelf = new Shelf();
        shelf.addBook(book1);
        shelf.addBook(book5);
        shelf.addBook(book2, book3,book5);//все переданные аргументы собираются в массив, ссылка на массив будет присвоена локальной переменной books

        // вывод имени автора первой книги на полке
        System.out.println(shelf.getBooks()[0].getAuthor().name);
        // 1. shelf - экземпляр класса Shelf
        // 2. shelf.getBooks() метод вернет ссылку на значение свойства books объекта shelf - массив книг
        // 3. shelf.getBooks()[0] обратились к элементу массива с индексом 0 - экземпляр класса Book
        // 4. shelf.getBooks()[0].getAuthor() метод вернет ссылку на значение свойства author книги
        // 5. shelf.getBooks()[0].getAuthor().name получили значение свойства name автора

        System.out.println(shelf.toString());




    }
}
