package ru.itmo.lessons.questions.question6;

import java.util.Arrays;

public class PrimitiveWrapper {
    private static void print(Double[] doubles){
        System.out.println(Arrays.toString(doubles));
    }
    public static void main(String[] args) {
        // byte - Byte, boolean - Boolean, int - Integer,
        // long - Long, char - Character, double - Double, float - Float
        // автоупаковка - переменной обертки присваивается значение примитива
        // автораспаковка - наоборот
        // автоупаковка не работает, если примитив не соответствует типу
        // класса обертки
        // Byte byteObj = 500;

        /*byte one = 1;
        Integer integer = *//*(int)*//* one;
        Byte two = 2;
        int num = two;
        // автоупаковка и автораспаковка не работают с массивами
        double[] doubles = {45.8, 9.1, -9.7};
        print(doubles);*/


        Integer x = 89;
        Integer y = 89;

        Integer a = 500;
        Integer b = 500;

        System.out.println(x == y); // true
        System.out.println(a == b); // false
    }


}