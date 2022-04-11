package ru.itmo.lessons.lesson16;

/*аннотация временной компиляции*/
@FunctionalInterface // содержит один абстрактный метод
// и илюбое кол-во default или static методов с реализацией
public interface Operation {
    /*public*/ double execute(double a, double b);
}
