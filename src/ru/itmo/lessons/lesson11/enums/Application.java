package ru.itmo.lessons.lesson11.enums;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Article article1 = new Article("Путешествие по Австралии");
        article1.setCountry(Country.AUSTRALIA); // обращение к final static объектам перечисления
        System.out.println(article1.getCountry());

        Article article2 = new Article("Путешествие по Великобритании");
        article2.setCountry(Country.UK); // обращение к final static объектам перечисления
        System.out.println(article2.getCountry());

        // методы перечислений (у всех одинаковые)
        // получение массива констант
        Country[] countries = Country.values();
        System.out.println(Arrays.toString(countries)); // в каком порядке в перечислении при объявлении, в таком и в массиве, никогда не поменяют порядок

        // индекс элемента перечисления в массиве
        System.out.println(Country.FRANCE.ordinal()); // 2

        for (Country country : countries) {
            System.out.println("country " + country.name());  // возврат строкового представления
        }

        // IllegalArgumentException, если элемент не будет найден
        Country country = Country.valueOf("UK"); // возврат ссылки на элемент перечисления
        System.out.println(country); // UK

        Priority low = Priority.LOW;
        System.out.println(low.getCode());
        low.setCode(2);
        System.out.println(low.getCode()); //

        Priority[] priorities = Priority.values();
        for (Priority priority : priorities) {
            System.out.println("Code of " + priority.name() + " is " + priority.getCode());
        }

        for (Priority value : Priority.values()) {
            System.out.println(value.getCode());
        }

        // по умолчанию name() и toString() возвращают одно значение, НО
        // name() - final - переопределить нельзя
        // toString() - переопределить можно
        System.out.println(Priority.LOW.name()); // "LOW"
        System.out.println(Priority.LOW.toString()); // "LOW"


        int sumRes = Operation.SUM.action(12, 3);
        System.out.println(sumRes);
        int multiRes = Operation.MULTI.action(12, 3);
        System.out.println(multiRes);

        // Operation.SUM.some();

        /*  создать enum, перечисляющий 3 любые планеты солнечной системы
            в методе main перебрать массив с элементами перечисления,
            вывести массу, радиус и название каждой планеты
            значения всех свойств изначально задаются через конструктор
            должна быть возможность изменить массу и радиус планет*/


        for (Planet value : Planet.values()) {
            System.out.println("Планета " + value.getName() + ": масса - " + value.getWeight() + ", радиус - " + value.getRadius());
        }
    }
}
