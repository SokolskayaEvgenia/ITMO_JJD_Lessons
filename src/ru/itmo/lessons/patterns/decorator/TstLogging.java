package ru.itmo.lessons.patterns.decorator;

public class TstLogging {
    public static void main(String[] args) {
        ClassInProgram inProgram = new ClassInProgram(new ConsoleLogging());
        inProgram.action();

        inProgram.setStrategy(new DateDecorator(new FileLogging()));
        inProgram.action();

        inProgram.setStrategy(new DateDecorator(new CodeDecorator(new ConsoleLogging())));
        inProgram.action();
    }
}