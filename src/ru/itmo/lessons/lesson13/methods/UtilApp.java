package ru.itmo.lessons.lesson13.methods;

public class UtilApp {
    public static void main(String[] args) {
        String[] strings = {"qwe", "asd", "zxc"};
        String string = "qwe";
        System.out.println(CustomUtils.inArray(strings, string));
        System.out.println(CustomUtils.<String>inArray(strings, string));
        //System.out.println(CustomUtils.<String>inArray(strings,1));
        // если изначально сообщаем <тип> передаваемых аргументов, и передадим другой тип,
        // то программа будет показывать ошибку на моменте компиляции
        // если изначально тип не передаем, то программа воспринимает все аргументы,
        // как Object

        Integer[] integers = {2, 4, 6};
        Integer integer = 34;
        System.out.println(CustomUtils.<Integer>inArray(integers, integer));

        System.out.println(CustomUtils.compareHashCode(12, "12"));
        System.out.println(CustomUtils.<Number, String>compareHashCode(12, "12"));
    }
}
