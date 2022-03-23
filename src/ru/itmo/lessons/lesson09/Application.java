package ru.itmo.lessons.lesson09;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Point a = new Point(23, -12);
        Point b = new Point(23, -12);

        System.out.println(a); // System.out.println(a.toString());
        System.out.println(b); // System.out.println(b.toString());

        // сравнение ссылок
        System.out.println(a == b); //false

        // по умолчанию метод equals сравнивает ссылки
        // и должен быть переопределен в классе
        System.out.println(a.equals(b)); // true

        // клонирование (метод clone())
        // модификатор по умолчанию protected, необходимо переопределить
        Point aClone = a.clone();
        System.out.println(a == aClone); // false
        System.out.println(a.equals(aClone)); // true

        Point c = new Point(12,33);
        Point d = new Point(45,11);
        Point f = new Point(-8,-9);

        Figure figure = new Figure(3);
        figure.addPoint(a);
        figure.addPoint(b);
        figure.addPoint(c);
        figure.addPoint(d);
        figure.addPoint(f);

        System.out.println(figure);

        Figure figureClone = figure.clone();
        System.out.println(figure.equals(figureClone)); // true
        System.out.println(figure.getPoints() == figureClone.getPoints()); // false - разные ссылки на массивы
        System.out.println(Arrays.equals(figure.getPoints(), figureClone.getPoints())); // true - сравнение массивов через equals
        System.out.println(figure.getPoints()[0]==figureClone.getPoints()[0]); // false - разные точки
        System.out.println(figure.getPoints()[0].equals(figureClone.getPoints()[0])); // true - сравнение точек через equals
    }
}
