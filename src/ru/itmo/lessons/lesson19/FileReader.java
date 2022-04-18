package ru.itmo.lessons.lesson19;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class FileReader {

    // пакеты для работы с файлами:
    // java.io - обмен данными через последовательность байт, есть классы, которые работают через последовательность char
    // java.nio

    // объект класса File
    // new File(файл или директория);

    // классы из пакета java.io работают следующим образом:
    // программа    <->       источник
    // InputStream (байты) - отвечает за получение данных (поток байт) в программу
    // OutputStream (байты) - описывает отправку данных в различные источники из программы

    // Reader (char) - получение потока char в программу
    // Writer (char) - описывает отправку данных в различные источники

    // FileInputStream / FileOutputStream
    // ObjectInputStream / ObjectOutputStream - представление объекта в последовательность байт

    // FileInputStream(ObjectInputStream(CustomStream(объект)))
    // FileInputStream(CustomStream(ObjectInputStream(объект)))

    // наш класс прослойки CustomStream должен наследоваться от FilterInputStream

    public static boolean writeToFile(byte[] data, File file) {
        boolean result = false;
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)) /*throw FileNotFoundException*/ {
            //false - перезапись файла (по умолчанию), true - дозапись в файл
            // try with resources (java 7) - можно создать объект любого класса, который реализует интерфейс AutoCloseable
            // и его  абстрактный метод void close(); можно создать более одного объекта через ";"
            // если открытие ресурсов в круглых скобках try, то закрытие произойдет автоматически:
            // 1. все инструкции блока try выполнены без ошибок
            // 2. в блоке try произошла ошибка. Ресурсы будут закрыты до перехвата исключения блоком catch

            // если try with resources не используется, закрывать ресурсы нужно в блоке finally
            // - закрытие ресурсов будет происходить после блока catch
            fileOutputStream.write(data);
            result = true;
        } catch (FileNotFoundException e) {
            System.out.println("");
        } catch (IOException e) { // FileNotFoundException - наследник IOException
            System.out.println("Не удалось записать данные в файл");
        }
        return result;
    }

    public static byte[] readFromFile(File file) {
        byte[] result = null;
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            result = fileInputStream.readAllBytes();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Не удалось использовать файл");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Не удалось прочитать данные из файла");
        }
        return result;
    }

    public static boolean writeFromConsole(File file) {
        boolean result = false;
        // основной функционал
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true);
             // декоратор
             BufferedOutputStream buffer = new BufferedOutputStream(fileOutputStream)) { // задача буфера только накопление данных
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Введите данные или stop для выхода");
                String userInput = scanner.nextLine();
                if ("stop".equalsIgnoreCase(userInput)) break;
                buffer.write(userInput.getBytes()); // декоратор OutputStream после того, как накопит данные,
                // сам вызовет метод write для передачи данных в основной функционал
            }
            result = true;
        } catch (IOException e) {
            System.out.println("Проблемы с записью в файл");
        }
        return result;
    }

    public static String readWithBuffer(File file) {
        String result = null;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[300];
            int count;

            while ((count = bufferedInputStream.read(buffer)) != -1) {
                byteArray.write(buffer, 0, count);
            }
            result = byteArray.toString();

        } catch (IOException e) {
            System.out.println("Ошибка чтения");
        }
        return result;
    }

    // методы для преобразования изображений в байты

    public static boolean byteArrayToImage(File file, byte[] bytes) throws IOException {
        try (ByteArrayInputStream byteArrayInput = new ByteArrayInputStream(bytes)) {
            BufferedImage image = ImageIO.read(byteArrayInput);
            return ImageIO.write(image, "png", file);
        }
    }

    public static byte[] imageToBytes(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream arrayOutput = new ByteArrayOutputStream();
        ImageIO.write(image,"png", arrayOutput);
        return arrayOutput.toByteArray();
    }
}
