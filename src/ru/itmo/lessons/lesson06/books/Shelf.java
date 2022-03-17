package ru.itmo.lessons.lesson06.books;

import java.util.Arrays;

public class Shelf {
    private String color = "white";// цвет полки
    // книга
    private Book[] books = new Book[4];

    public Book[] getBooks() {
        return books;
    }

    public void setColor(String color) {
        if (color == null || color.length() < 4) {
            throw new IllegalArgumentException("В названии цвета должно быть не менее 4 символов");
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    //метод позволяет добавить одну книгу на полку
    public void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
        System.out.println("Книге '" + book.getTitle() + "' автора " + book.getAuthor().getFullName() + " не хватило места на полке ");
    }

    // метод добавления нескольких книг на полку
    public void addBook(Book... books) {
        System.out.println(Arrays.toString(books));
        for (Book book : books) {
            addBook(book); // вызов метода addBook(Book book)
        }
    }
}
