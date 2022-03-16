package lesson05;

import java.sql.Array;
import java.util.Arrays;
import java.util.Locale;

public class StringLesson {
    public static void main(String[] args) {
        //char - (примитивный тип) 16 битный символ Unicode
        //0 до 65536 / '\u0000' до '\uffff'

        char char1 = 'J'; // сам символ
        //в одинарные кавычки помещается один символ, двойные кавычки уже строка
        char char2 = 74; //номер символа J
        char char3 = '\u0044'; //шестнадцатеричное представление символа в escape последовательности из таблицы
        System.out.print(char1);
        System.out.print(char2);
        System.out.print(char3);
        System.out.println("\nСтроки");

        // Строка - упорядоченная последовательность символов
        // Строка - ссылочный тип, является экземпляром класса String
        // Строки задаются:
        // 1. в двойных кавычках
        // 2. используется конструктор new String() - используется, если способ создания строки через "" кавычки невозможен
        // Строки неизменны, можно лишь создать новую строку на основе существующей (приведение регистра, замена..)
        System.out.println("Строковый литерал");
        //создается экземпляр класса String, но к нему нельзя обратиться, т.к. не объявлена переменная, нет ссылки

        char[] chars = {'\u004A', '\u004A', '\u0044'};
        String jjdString = new String(chars);
        System.out.println(jjdString); //JJD
        System.out.println(jjdString.length()); //3
        char[] chars1 = {'\uD83D', '\uDC38'}; // суррогатная пара чаров - создает один символ
        String frogString = new String(chars1);
        System.out.println(frogString); //🐸
        System.out.println(frogString.length()); //2
        System.out.println(frogString.codePoints().count()); // 1 - действительное количество символов

        // Хранение строк до JAVA 9: массив char[] в кодировке UTF-16, каждый чар был представлен двумя байтами

        // Начиная с 9 версии строки (компактные строки)
        // хранятся как массив byte[]
        // + у каждой строки сохраняется кодировка LATIN1 (1 символ 1 байт) или UTF-16 (1 символ 2 байта)

        // Пул строк для оптимизации, чтобы не хранить одно и то же
        // Пул строк хранит только одну копию строкового литерала
        // т.е. набор уникальных строк
        // Пул строк: "Строка"  "Строка4"
        // "Строка" (heap память)


        String string1 = "Строка"; // добавляется в пул строк, создается объект
        String string2 = "Строка"; // в пул строк не добавляетс, новый объект не создается, ссылается на имеющийся объект
        //string1 = "Строка4"; // string1 не ссылается на "Строка"

        String string3 = new String("Строка");
        //в пуле строк не создается, создается новый объект в памяти, где хранятся все остальные объекты (в куче)

        System.out.println(string1 == string2); //true - (сравнение ссылок) ведут к одному участку памяти
        System.out.println(string1 == string3); //false - (сравнение ссылок)ведут к разным участкам памяти

        String internString = string3.intern();
        // процесс интернирования - смотрит пул строк: если в нем есть такая строка, то метод возвращает ссылку на строку из пула
        // если строки в пуле нет, то добавляет и возвращает ссылку


        // Сравнение строк
        // Строки через == не сравниваем, сравниваются ссылки на объект (характерно для всех ссылочных типов)

        System.out.println(string1.equals(string2));// string1 сравниваем с string2 -> true // Since: 1.4
        System.out.println("строка".equals(string2)); // false - регистр учитывается
        System.out.println("строка".equalsIgnoreCase(string2)); // true - без учета регистра

        string2 = null;

        System.out.println("строка".equals(string2)); // вариант безопаснее
        //System.out.println(string2.equals("строка")); // у null нет метода equals, программа упадет с ошибкой
        //NullPointerException - ошибка времени исполнения

        // Проверка на null - обычное сравнение
        System.out.println(string2 == null); //true
        System.out.println(string2 != null); //false

        string1 = "Java";
        string2 = "Python";

        // конкатенация строк
        String concatString = string1 + " :: " + string2;
        System.out.println(concatString);

        concatString = string1.concat(" :: ").concat(string2);
        System.out.println(concatString);

        concatString = String.join(" :: ", string2, string1); //Since: 1.8
        System.out.println(concatString);

        concatString = "";
        // так делать не надо: создается слишком много объектов
        /*for (int i = 0; i < 10; i++) {
            concatString += i + " ";
        }
        System.out.println(concatString);*/

        // Складывать строки без создания новых объектов позволяют
        //StringBuilder - работает быстрее, в многопоточных приложениях могут быть проблемы. Since: 1.5
        //StringBuffer - потокобезопасный и может использоваться в многопоточных приложениях. Since: 1.0

        concatString = "Начало строки ";
        StringBuilder sb = new StringBuilder(concatString); // можно ничего не передавать (склейка начнется с пустоты)
        sb.append(string1).append(" :: ").append(string2);
        System.out.println(sb);

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb2.append(i).append(" ");
        }
        System.out.println(sb2); // в методе println реализован вызов метода toString

        String sbString = sb2.toString(); // возвращение строки, которую накопил StringBuilder
        System.out.println(sbString);

        // метод split()
        String langs = "Java, Python, JavaScript";
        String[] langArr = langs.split(", "); //Since: 1.8
        System.out.println(Arrays.toString(langArr));

        //методы замены
        String newString = langs.replaceAll(", ", " - "); //Since:1.5 // поддерживает регулярные выражения
        System.out.println(newString);

        newString = langs.replaceFirst(", ", " - "); //Since: 1.4
        System.out.println(newString);

        newString = langs.replace(", ", " - "); //Since: 1.5 // не поддерживает регулярные выражения
        System.out.println(newString);

        // contains - содержит ли строка конкретную последовательность символов. Since: 1.5
        System.out.println(langs.contains("th"));// true
        // startWith проверяет начинается ли строка указанной последовательности символов. Since: 1.0
        // зависит от регистра
        System.out.println(langs.startsWith("j")); //false
        // endsWith проверяет оканчивается ли строка указанной последовательности символов
        // зависит от регистра
        System.out.println(langs.endsWith("Script")); //
        System.out.println(langs.startsWith("av",1)); //true

        String name = "Иван";
        String surname = "Петров";
        String fullName1 = name+" "+surname; //конкатенация на моменте выполнения
        String fullName2 = "Иван"+" "+"Петров"; //конкатенация во время компиляции
        System.out.println(fullName1);
        System.out.println(fullName2);
    }
}
