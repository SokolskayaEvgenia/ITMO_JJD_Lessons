package lesson01;

public class FirstLesson {
//    однострочный комметарий
    /*многострочный
    комментарий*/

    /**
     *
     * документирование кода
     */
    public static void main(String[] args) {
        System.out.println("Информация для вывода в консоль");
        //типДанных имяПеременной
        int size;
        size = 56;
        int count = 71899;
        int lenght = 122, width = 500;
        count = 800_000;
        System.out.println(count);
        //integer number too large
        long veryBig = 67_000_000_000L;

        //деление целых чисел на 0
        //System.out.println(count/0);


        double price = 56.7;
        float temp =-78.3f;

        //деление чисел с плавающей точкой на ноль
        System.out.println(price/0);
        System.out.println(temp/0);
        count = 8700;
        price = count;
        System.out.println(price);

        //явное приведение типов
        byte small = (byte) count;
        System.out.println(small);

        //операторы

        int a = 9, b = 4;
        //int c = a/b;
        double c = (double) a/b;
        System.out.println(c);

        byte x = 6, y =12;
        byte z = (byte) (x+y);

        //%
        lenght = 9;
        width = 2;
        System.out.println(lenght%width);
        //4.5 4.5
        //0.5 + 0.5 = 1

        //операторы присваивания
        int num = 10;
        num += 10; //num = num + 10
        num -= 10; //num = num - 10
        num *= 10; //num = num * 10
        num /= 10; //num = num / 10
        num %= 10; //num = num % 10

        //тернарный оператор
        int start = 3, end = 5000;
        int res = start > end ? end-start : 0;
        System.out.println(res); //0
    }


}
