package ru.itmo.lessons.questions.question2;

public class Child extends Parent{

    public static void childStaticVoid1(){
        // какие методы родителя можно вызвать?
        random(12, 45);
    }

    public void childVoid1(){
        // какие методы родителя можно вызвать?
        super.void1();
        super.void3();
        super.void4();
        random(34, 78);
    }

    // какие методы можно переопределить?
    /* @Override */
    // void1, void4
    // статический метод переопределить нельзя
    // private метод переопределить нельзя

    // что лишнее?
    public /* final */ static void childStaticVoid2(){
        System.out.println("Статический метод");
    }
}