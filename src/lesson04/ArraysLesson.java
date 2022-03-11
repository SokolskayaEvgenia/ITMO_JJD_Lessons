package lesson04;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysLesson {

    public static void main(String[] args) {

        /*
        //примитивные типы данных
        int a = 78; // [100] a
        int b = a;  // [78] b
        a = 100;

        //ссылочные типы данных
        Scanner scanner = new Scanner(System.in); // in [scanner] scanner
        Scanner in = scanner;

         */

        int[] ints1 = new int[7]; //создание массива на 7 элементов, по умолчанию 0
        //System.out.println(ints1); //в таком виде массив не вывести
        System.out.println(Arrays.toString(ints1));

        int[] ints2 = {6, -90, 56, 12, 0, -44}; //длина массива 6, её изменить не можем
        System.out.println(Arrays.toString(ints2));

        ints2 = new int[3];
        System.out.println(Arrays.toString(ints2));

        // ints2 = {34,78,12} - так делать нельзя
        ints2 = new int[]{34, 78, 12, 78};
        System.out.println(Arrays.toString(ints2));

        //длина массива - положительное значение типа int
        //можно задавать любым выражением, дающим int
        int length = 10;
        int[] ints3 = new int[length];
        int[] ints4 = new int[length + 5];
        System.out.println(Arrays.toString(ints4));
        System.out.println(ints4.length); //15

        //доступ к элементам массива
        System.out.println(ints2[3]); //вывод 4 элемента массива - 78
        ints4[2] = 56; //присвоение значения 3 элементу массива
        System.out.println(Arrays.toString(ints4));

        //ошибка времени выполнения
        //ArrayIndexOutOfBoundsException - выход за пределы массива
        //System.out.println(ints4[100]);

        //многомерный массив - элемент массива другой массив
        //[ [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
        int[][] ints5 = new int[3][4];
        System.out.println(Arrays.deepToString(ints5));
        //[ [0, 0], [0, 0, 0], [0, 0, 0, 0]]
        int[][] ints6 = new int[3][]; // [ null, null, null]
        ints6[0] = new int[2]; // [ [0, 0], null, null]
        ints6[1] = new int[3]; // [ [0, 0], [0, 0, 0], null]
        ints6[2] = new int[4]; // [ [0, 0], [0, 0, 0], [0, 0, 0, 0]]
        System.out.println(Arrays.deepToString(ints6));
        ints6[2][1] = 90;
        System.out.println(Arrays.deepToString(ints6)); // [[0, 0], [0, 0, 0], [0, 90, 0, 0]]

        //перебор массива
        int[] ints7 = {3, -6, 12, 0, 4};
        // for - используется, если нужно изменить значение элемента массива
        // 0   1   2  3  4
        //[3, -6, 12, 0, 4]
        // найти сумму значений элементов массива ints7
        int sum = 0;
        for (int index = 0; index < ints7.length; index += 1) {
            ints7[index] *= ints7[index];
            sum += ints7[index];
        }
        System.out.println(sum);

        //foreach
        // не дает возможность изменить элементы массива
        // не предоставляет доступ к индексу элемента
        //не надо определять размер массива
        //от первого элемента к последнему
        //element - значения элементов массива, не индекс
        int summ = 0;
        for (int element : ints7) {
            System.out.print(element + " ");
            summ += element;
        }
        System.out.println(summ);

        //найти и вывести в консоль
        //минимальное значение элемента массива int8
        double[] ints8 = {3.7, -6.2, 12.9, 0.4, 4.1};
        double minValue = ints8[0];
        for (double el : ints8) {
            if (minValue > el) minValue = el;
        }
        System.out.println(minValue);

        //вывести в консоль случайный элемент массива int8
        //использовать Math.random()
        System.out.println(ints8[(int)(Math.random()*ints8.length)]);

        //сортировка
        Arrays.sort(ints8); //сортировка в порядке возрастания
        System.out.println(Arrays.toString(ints8));

        //метод бинарного поиска принимает на вход массив и значение и возвращает индекс этого значения
        //если элемент в массиве не найден, то возвращается отрицательное число
        // [-6.2, 0.4, 3.7, 4.1, 12.9]
        int element = Arrays.binarySearch(ints8, 3.7);
        System.out.println(element); // 2
        //метод работает с отсортированным массивом
        element = Arrays.binarySearch(ints8, 4); // (3+1) возможное положение элемента + 1 и знак -
        System.out.println(element); // -4
        element = Arrays.binarySearch(ints8, 13); // (5+1) возможное положение элемента + 1 и знак -
        System.out.println(element); // -6

        double[] ints9 = {3.7, -6.2, 12.9, 0.4, 4.1};
        //double[] ints10 = ints9; //это не копирование, означает, что можно по разным ссылкам обращаться к одному массиву
        double[] cloneInts9 = ints9.clone(); //вызвать метод clone: два разных массива с одинаковыми элементами

        //Arrays.copyOf
        double[] copyInts9 = Arrays.copyOf(ints9,3); //элементы берутся с начала
        System.out.println(Arrays.toString(copyInts9));

        //System.arraycopy
        //из какого массива, с какого индекса, в какой массив, с какого индекса, сколько элементов
        double[] newDoubles = new double[10];
        System.arraycopy(ints9,1, newDoubles,3, 2);
        //[0.0, 0.0, 0.0, -6.2, 12.9, 0.0, 0.0, 0.0, 0.0, 0.0]
        System.out.println(Arrays.toString(newDoubles));

        //алгоритм быстрой сортировки
        //разобраться и рассказать на следующем занятии



    }
}
