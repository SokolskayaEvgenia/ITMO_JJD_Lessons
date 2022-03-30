package ru.itmo.lessons.questions.question5;

import java.util.Arrays;

public class Storage {
    private String[] strings;
    private int lastIndex; // значение по умолчанию 0, т.к. тип int

    public Storage(int len) {
        if (len < 1) {
            throw new IllegalArgumentException("Задайте размер массива");
        }
        strings = new String[len];
    }

    public void addString(String newString) {
        if (lastIndex == strings.length) {
            System.out.println("Элементу \'" + newString + "\' не хватило места");
            return;
        }
        strings[lastIndex] = newString;
        lastIndex +=1;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "strings=" + Arrays.toString(strings) +
                '}';
    }
}