package ru.itmo.lessons.lesson13.methods;

public class CustomUtils {
    // типизированные методы (generic methods)
    // метод, который проверяет наличие элемента в массиве

    //у element и у массива можно вызвать только методы класса Object
    // если вызываем generic типы, то любой тип, кроме примитивных
    public static <T> boolean inArray(T[] arr, T element) {
        if (arr == null || element == null) {
            throw new IllegalArgumentException("arr и element не могут быть null");
        }
        for (T t : arr){
            if (element.equals(t)) return true;
        }
        return false;
    }

    // если метод собирается принять на вход или возвращать разные типы данных
    // при вызове Т может быть Number и любым из его родителей
    // при вызове K может быть String и любым из его родителей
    public static <T extends Number, K extends String>
    int compareHashCode(T first, K second){
        // у first можно вызвать методы Number и его родителей
        // у second можно вызвать методы String и его родителей
        return Integer.compare(first.hashCode(), second.hashCode());
    }
}
