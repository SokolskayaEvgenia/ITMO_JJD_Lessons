package ru.itmo.lessons.patterns.observer;

import java.util.ArrayList;

public class StateClass {
    // коллекция слушателей/наблюдателей
    private ArrayList<EventListener> eventListeners = new ArrayList<>();

    public void addListener(EventListener eventListener) {
        eventListeners.add(eventListener);
    }

    public void removeListener(EventListener eventListener) {
        eventListeners.remove(eventListener);
    }

    private void lowNotify(int code) {
        eventListeners.forEach(someInterface -> someInterface.greenEvent(code));
    }

    private void mediumNotify(int code) {
        eventListeners.forEach(someInterface -> someInterface.yellowEvent(code));
    }

    private void highNotify(int code) {
        eventListeners.forEach(someInterface -> someInterface.redEvent(code));
    }

    public void changeState(String newValue) {
        if ("ok".equals(newValue)) lowNotify(1);
        if ("warn".equals(newValue)) mediumNotify(5);
        if ("error".equals(newValue)) highNotify(10);
    }
}