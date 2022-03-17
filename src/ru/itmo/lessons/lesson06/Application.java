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
        author1.name = "Федор";
        author1.surname = "Достоевский";
        author2.name = "Лев";
        author2.surname = "Толстой";
        // вызов методов
        author1.printFullName();
        author2.printFullName();
        System.out.println(author1.getFullName());
        System.out.println(author2.getFullName());

        Book book1 = new Book(author1); //создание объекта - вызов конструктора
        book1.setTitle("Книга");// от 3 символов
        System.out.println(book1.getTitle());
        book1.setPages(22);
        System.out.println(book1.getPages());
        Shelf shelf = new Shelf();
        shelf.addBook(book1);
        shelf.addBook(book1, book1,book1);//все переданные аргументы собираются в массив, ссылка на массив будет присвоена локальной переменной books

        // вывод имени автора первой книги на полке
        System.out.println(shelf.getBooks()[0].getAuthor().name);

        //book1.title = "";
        //book1.pages = -34;


    }
}
