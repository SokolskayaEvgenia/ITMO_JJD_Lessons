package ru.itmo.lessons.lesson20.serialization;

import java.io.*;

public class BinHandler {
    private File file = new File("src/ru/itmo/lessons/lesson20/serialization/lesson20.bin");

    public BinHandler(){}

    public BinHandler(File file){
        this.file = file;
    }

    public <T> boolean writeToFile(T object){
        boolean result = false;
        try(FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)){
            objectOutput.writeObject(object); // строка вызовет ошибку, если T не имплементирует Serializable
            // сериализует все свойства со значениями объекта, а также передается ссылка на класс
            result = true;
            // объект превращается в последовательность байт (objectOutput)
            // последовательность байт записывается в файл (fileOutput)
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public <T> T readFromFile(){
        Object result = null;
        try(FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput)){
            result = objectInput.readObject(); // Object
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return (T)result;
    }
}
