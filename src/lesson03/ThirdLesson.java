package lesson03;

import java.util.Scanner;

public class ThirdLesson {
    public static void main(String[] args) {

        /*
        double randomValue = Math.random(); // [0,1)
        // [0;7)
        System.out.println((int) (randomValue * 7));
        // [3;7)
        System.out.println((int) (3 + randomValue * 4));

        //пользовательский ввод
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        int userNumber = in.nextInt();
        System.out.println(userNumber * userNumber);

        //циклы

        while (true){
            System.out.println("Введите целое положительное число или 0 для выхода из программы: ");
            userNumber = in.nextInt();
            if (userNumber== 0) break; // завершение текущего цикла
            if (userNumber < 0) continue; // переход на следующую итерацию
            System.out.println(userNumber * userNumber);
        }

        do {
            System.out.println("DO WHILE: Введите целое положительное число или 0 для выхода из программы: ");
            userNumber = in.nextInt();
            if (userNumber < 0) continue;
            System.out.println(userNumber * userNumber);
        } while (userNumber != 0);


        int start = 1, end = 12;
        //вывести все четные числа от start до end
        // четное число % 2 == 0
        // 2 4 6 8 10 12

        while (start <= end) {
            if (start % 2 == 0) System.out.println(start);
            start += 1;
        }

        for (start=1, end=12; //инициализация переменных
             start <= end; // булевое выражение (условие)
             start+=1) //обновление значений переменных
        {
            if (start % 2 == 0) System.out.println(start);
        }

        //вывести все неотрицательные элементы последовательности
        // 90 85 80 75 ....0

        for (int num = 90; num >= 0; num -= 5) {
            System.out.print(num + " ");
        }

        //вывести на экран первые десять элементов последовательности
        //2 4 6 8

        for (int i = 1, num = 2; i <= 10; i++, num += 2) {
            System.out.print(num + " ");
        }*/

        /*
        цикл while
        считать с консоли количество тарелок и моющего средства
        моющее средство расходуется из расчета 0.5 на 1 тарелку
        в цикле выводить сколько моющего средства осталось после мытья каждой тарелки
        после цикла вывести, сколько тарелок и моющего средства осталось
         */

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество тарелок: ");
        int plates = in.nextInt();
        System.out.println("Введите количество моющего средства: ");
        double fairy = in.nextDouble();

        while (plates > 0 && fairy > 0) {
            plates -= 1;
            fairy -= 0.5;
            if (plates != 0 && fairy != 0) System.out.println("Моющего средства осталось: " + fairy);
        }
        if (plates == 0 && fairy == 0) System.out.println("Все тарелки вымыты! \nМоющего средства не осталось!");
        else if (plates != 0 && fairy == 0)
            System.out.println("Моющее средство закончилось! \nТарелок осталось: " + plates);
        else System.out.println("Все тарелки вымыты! \nМоющего средства сталось: " + fairy);
    }
}
