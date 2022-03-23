package ru.itmo.lessons.lesson07.base;

// родительский класс всех персонажей
// может содержать абстрактные методы
abstract public class Unit {
    protected int healthScore; //доступ к свойству разрешен из текущего класса + из дочернего
    private int maxHealthScore;

    public Unit(int healthScore){
        if(healthScore<1) throw new IllegalArgumentException("Здоровье должно быть > 0");
        this.healthScore = healthScore;
        maxHealthScore = healthScore;
    }

    public int getHealthScore() {
        return healthScore;
    }

    //добавить здоровье, но не больше изначального, если персонаж жив
    public void plusHealth(int healthScore){
        if (!isAlive()) return;
        this.healthScore = Math.min(this.healthScore+healthScore, maxHealthScore);

    }
    //уменьшить здоровье, если персонаж еще жив
    public void minusHealth(int healthScore){
        if (!isAlive()) return;
        this.healthScore -=healthScore;
    }

    //метод вернет true, если здоровье больше 0, false, если нет
    public boolean isAlive(){
        return healthScore>0;
    }

    // абстрактный метод - метод без реализации (без {})
    public abstract void rest();
}
