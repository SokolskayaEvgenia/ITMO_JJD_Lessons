package ru.itmo.lessons.lesson07.base;

import ru.itmo.lessons.lesson07.Infantry;
import ru.itmo.lessons.lesson07.Knight;

// дочерний класс BattleUnit наследуется от родительского класса Unit
// делаем класс абстрактным, т.к. он для хранения дублирующихся свойств
abstract public class BattleUnit extends Unit implements AttackAble {
    protected int attackScore;

    public BattleUnit(int healthScore, int attackScore) {
        super(healthScore); // вызов родительского конструктора
        if (attackScore < 1) throw new IllegalArgumentException("Атака должна быть положительной");
        this.attackScore = attackScore;
    }

    public int getAttackScore() {
        return attackScore;
    }

    // переопределять final метод нельзя
    public final void battleUnitVoid() {
        System.out.println("Метод BattleUnit");
    }

    public boolean runFromField() {
        // при бегстве юнит теряет 1ед здоровья
        if (!isAlive()) {
            System.out.println("Юнит не может сбежать");
            return false;
        }
        healthScore -= 1;
        if (!isAlive()) {
            System.out.println("Юнит не смог сбежать");
            return false;
        }
        return true;
    }

    // метод генерации боевых юнитов
    public static BattleUnit getBattleUnit(){
        String[] types = {"knight", "infantry"};
        BattleUnit unit = null;
        int randomIndex = (int)(Math.random()* types.length);
        switch (types[randomIndex]){
            case "knight":
                unit = new Knight(30,50);
                break;
            case "infantry":
                unit = new Infantry(35,20);
                break;
        }
        return unit;
    }

    public static BattleUnit[] getBattleUnits(int count){
        BattleUnit[] units = new BattleUnit[count];
        for (int i = 0; i < units.length; i++) {
            // в статических методах можно обратиться
            // только к статическим методам или свойствам
            units[i] = getBattleUnit();
        }
        return units;
    }
}
