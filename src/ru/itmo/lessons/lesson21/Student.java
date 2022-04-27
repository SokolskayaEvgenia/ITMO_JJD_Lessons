package ru.itmo.lessons.lesson21;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Exam> examList = new ArrayList<>();
    public void printExamInfo(){
        examList.forEach(System.out::println);
    }

    public Student(String name) {
        this.name = name;
    }

    public void addExam(Exam exam){
        examList.add(exam);
    }


    // вложенный класс (static)
    // 1. внешний класс не может быть static
    // 2. область видимости согласно модификаторам
    // 3. объект вложенного класса можно создать без объекта внешнего класса
    // 4. у вложенного класса нет доступа к нестатическим методам и свойствам внешнего класса

    public  static  class Exam{
        private String title;
        private int mark;

        public Exam(String title) {
            this.title = title;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }

        public String getTitle() {
            return title;
        }



        public int getMark() {
            return mark;
        }

        @Override
        public String toString() {
            return "Exam{" +
                    "title='" + title + '\'' +
                    ", mark=" + mark +
                    '}';
        }
    }
}
