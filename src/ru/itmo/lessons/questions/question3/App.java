package ru.itmo.lessons.questions.question3;

public class App {
    public static void main(String[] args) {
        Util util1 = new Util(); // - некорректная инструкция
        Util util2 = new Util(); // - некорректная инструкция

        util1.max = 1200; // некорректная инструкция
        System.out.println(util2.max); //1200 - некорректная инструкция

        Util.min = 100;
        Util.max = 200;

        System.out.println(util2.max); // - некорректная инструкция
        System.out.println(util1.min); // - некорректная инструкция


    }
}
