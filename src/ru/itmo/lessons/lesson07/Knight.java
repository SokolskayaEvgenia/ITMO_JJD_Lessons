package ru.itmo.lessons.lesson07;

import ru.itmo.lessons.lesson07.base.AttackAble;
import ru.itmo.lessons.lesson07.base.BattleUnit;

// Рыцарь
// здоровье
// очкиАтаки ++
// дополнительноеЗдоровье

// final запрещает наследование
// класс Knight реализует (имплементирует) интерфейс AttackAble
// можно реализовать несколько интерфейсов implements Int1, Int2
// класс обязан определить ВСЕ методы интерфейса, кроме default

public final class Knight extends BattleUnit {
    private final int additionHealth = 10;

    public Knight(int healthScore, int attackScore) {
        super(healthScore, attackScore);
    }

    public void knightVoid() {
        System.out.println("Метод knightVoid");
    }

    @Override
    public void rest() {
        plusHealth(3);
        System.out.println("Отдых рыцаря");
    }

    @Override
    public void attack(BattleUnit enemy) {
        if (enemy.isAlive() && this.isAlive()) enemy.minusHealth(attackScore);
        if (enemy.isAlive()) this.minusHealth(enemy.getAttackScore());
        if (this.isAlive()) this.plusHealth((int) (Math.random() * additionHealth));
    }

}
