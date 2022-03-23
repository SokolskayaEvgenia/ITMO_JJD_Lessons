package ru.itmo.lessons.lesson07.base;

// нельзя создать экземпляр
public interface AttackAble {
    public void attack(BattleUnit enemy); // public можно не писать
    // может быть метод с реализацией, но он должен быть default
    default void someVoid(){
        System.out.println("Метод с реализацией");
    };
}
