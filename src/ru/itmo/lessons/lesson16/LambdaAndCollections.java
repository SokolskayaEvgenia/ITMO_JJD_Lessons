package ru.itmo.lessons.lesson16;

import ru.itmo.lessons.lesson16.education.Course;
import ru.itmo.lessons.lesson16.education.University;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaAndCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourses(Course.getInstances(15));
        System.out.println(university.getCourses());

        // void accept(T t);
        // перебор коллекции - метод foreach
        Consumer<Course> soutCourse = course -> System.out.println(course);
        university.getCourses().forEach(soutCourse);
        university.getCourses().forEach(course -> System.out.println(course));
        // :: ссылка на метод(не вызов)
        // void accept(T t);
        university.getCourses().forEach(System.out::println);
        // TODO:: увеличить стоимость каждого курса на 10%
        university.getCourses().forEach(course -> course.setPrice(course.getPrice()*1.1));


        // TODO:: вывести названия каждого курса
        university.getCourses().forEach(course -> System.out.println(course.getName()));

        // TODO:: удалить из коллекции курсы, если их стоимость меньше 15000
        // removeIf
        university.getCourses().removeIf(course -> course.getPrice()<15000);

        // TODO:: написать реализацию метода getFilteredCourses, который принимает на вход Predicate<Course>
        //  и возвращает список отфильтрованных данным предикатом курсов университета

        // TODO::написать предикаты, которые возвращают true, если:
        //  1) курс дешевле 20000
        //  2) продолжительность курса 3 месяца или меньше
        //  3) название курса JJD

        Predicate<Course> lessPrice = course -> course.getPrice()<20000;
        Predicate<Course> lessDuration = course -> course.getDuration()<=3;
        Predicate<Course> isJJD = course -> course.getName().equalsIgnoreCase("jjd");


        // TODO:: Отфильтровать
        //  1) дешевле 20000
        //  2) дешевле 20000 и меньше 3х месяцев
        //  3) JJD или дешевле 20000

        List<Course> filtered = university.getFilteredCourses(lessPrice);
        filtered.forEach(System.out::println);
        filtered = university.getFilteredCourses(lessPrice.and(lessDuration));
        filtered.forEach(System.out::println);
        filtered = university.getFilteredCourses(isJJD.or(lessPrice));
        filtered.forEach(System.out::println);

        Comparator<Course> byName = (course1, course2) -> course1.getName().compareTo(course2.getName());
        university.getCourses().sort(byName);
        university.getCourses().forEach(System.out::println);

        Comparator<Course> byDuration = (course1, course2) -> Integer.compare(course1.getDuration(),course2.getDuration());
        university.getCourses().sort(byName.thenComparing(byDuration));
        university.getCourses().forEach(System.out::println);
    }
}