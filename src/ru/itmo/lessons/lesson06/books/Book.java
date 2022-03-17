package ru.itmo.lessons.lesson06.books;

import java.util.Objects;

public class Book {
    //свойства: название, автор, кол-во страниц
    private String title;
    private Author author;
    private int pages;

    public Book() {
    }

    public Book(Author author) {
        this.author = Objects.requireNonNull(author, "author не может быть null");
    }

    public Book(String title, Author author) {
        this(author);
        setTitle(title);
    }

    //если значения свойств private, но значения установить нужно, создаются методы
    //со всеми необходимыми проверками - сеттеры
    public void setTitle(String titleValue) {
        if (titleValue == null || titleValue.length() < 3) {
            throw new IllegalArgumentException("Значение title от 3 символов");
        }
        title = titleValue;
    }

    // методы, которые возвращают значения свойств - геттеры
    public String getTitle() {
        return title;
    }

    public void setPages(int pages) {
        if (pages < 10) throw new IllegalArgumentException("Количество страниц должно быть больше 10");
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public Author getAuthor() {
        return author;
    }

    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pages +
                ", author=" + author +
                '}';
    }
}

