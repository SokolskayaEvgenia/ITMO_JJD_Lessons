package ru.itmo.lessons.lesson16;

import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {
    private static void run(Operation some, double x, double y) {
        double res = some.execute(x, y);
        System.out.println("Результат: " + res);
    }

    public static void main(String[] args) {

        // TODO:: объявить интерфейс Operation с одним абстрактным методом,
        //  который принимает на вход два числа с плавающей точкой и возвращает число с плавающей точкой

        /* public interface Operation {
         *//*public*//* double execute(double firstNumber, double secondNumber);}*/


        // TODO:: написать несколько реализаций абстрактного метода

        // если метод принимает на вход один аргумент, то круглые скобки можно не ставить
        //  тип данных можно не указывать, они берутся из контекста, из интерфейса
        // если тело метода состоит из одной инструкции, фигурные скобки можно не ставить
        // если фигурных скобок нет, то метод возвращает результат, подразумевается return
        // если фигурные скобки есть, то return прописываем физически
        Operation plus = (firstNumber, secondNumber) -> /*return*/ firstNumber + secondNumber;
        Operation div = (firstNumber, secondNumber) -> {
            if (secondNumber == 0) return 0;
            return firstNumber / secondNumber;
        };

        System.out.println(plus.execute(34, 78));
        System.out.println(div.execute(45, 0));
        System.out.println(div.execute(45, 1));

        run(plus, 5.7, 5.2);
        run(div, 5.7, 2);

        // Predicate - функциональный интерфейс
        // используется для фильтраций
        // TODO:: написать реализации метода test:
        //  - проверка на положительное число
        //  - проверка на отрицательное число
        //  - проверка на четное число

        // boolean test(T t);
        Predicate<Integer> isPositive = number -> number > 0;
        Predicate<Integer> isNegative = number -> number < 0;
        Predicate<Integer> isEven = number -> number % 2 == 0;

        System.out.println(isPositive.test(-67)); // false
        System.out.println(isNegative.test(34)); // false
        System.out.println(isEven.test(34)); // true

        System.out.println(isPositive.and(isEven).test(68));
        System.out.println(isNegative.or(isPositive).test(0));

        // Function
        // TODO:: написать реализации метода apply:
        //  - уменьшение целого числа на 20%
        //  - увеличение числа в два раза
        //  - добавление к положительному числу символов " p."

        Function<Integer, Double> minus20 = number -> number * 0.8;
        Function<Integer, Integer> doubled = number -> number * 2;
        Function<Integer, String> addChars = number -> number + " р.";

        System.out.println(minus20.apply(21));
        System.out.println(doubled.andThen(addChars).apply(25));
        System.out.println(addChars.apply(36));
    }
}
