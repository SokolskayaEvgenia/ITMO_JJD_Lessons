package ru.itmo.lessons.lesson12;

// можно создавать собственные классы исключения
// если мы хотим создать исключение времени выполнения,
// то класс должен наследоваться от RuntimeException

// если мы хотим создать исключение времени выполнения,
// то класс должен наследоваться от Exception

// можно добавлять собственные методы и свойства
// можно вызывать конструкторы родителя
public class CalcException extends Exception {

    public CalcException(String message) {
        super(message);
    }

    // если наше исключение выбросилось в блоке catch
    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }

    // можно переопределять методы родителя
    @Override
    public String getMessage() {
        return super.getMessage() + "Будьте внимательны!";
    }
}
