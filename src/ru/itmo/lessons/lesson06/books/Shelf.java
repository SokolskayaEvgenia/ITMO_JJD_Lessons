package ru.itmo.lessons.lesson06.books;

public class Shelf {
    private String color = "white";// цвет полки
    // книга
    public Book[] books = new Book[10];

    public Book[] getBooks() {
        return books;
    }

    //метод позволяет добавить одну книгу на полку
    public void addBook(Book book){
        for (int i = 0; i < books.length; i++) {
            if (books[i]==null){
                books[i] = book;
                return;
            }
        }
        System.out.println("Нет места");
    }
    // метод добавления нескольких книг на полку
    public void addBook(Book... books){

    }
}
