package ru.itmo.lessons.patterns.observer;

// интерфейс, который реализуют слушатели или наблюдатели
public interface EventListener {
    void greenEvent(int code);
    void yellowEvent(int code);
    void redEvent(int code);
}