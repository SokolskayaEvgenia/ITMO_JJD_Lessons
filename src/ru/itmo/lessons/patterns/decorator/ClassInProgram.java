package ru.itmo.lessons.patterns.decorator;

public class ClassInProgram {
    private ILog strategy;

    public ClassInProgram(ILog strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ILog strategy) {
        this.strategy = strategy;
    }

    public void action(){
        strategy.log("Логирование действия");
    }
}