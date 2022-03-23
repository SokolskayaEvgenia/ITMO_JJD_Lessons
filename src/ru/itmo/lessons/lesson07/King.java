package ru.itmo.lessons.lesson07;

import ru.itmo.lessons.lesson07.base.BattleUnit;
import ru.itmo.lessons.lesson07.base.Unit;

// Король
// здоровье
// золото
// армия боевых юнитов
// final запрещает наследование
public final class King extends Unit {
    private int gold = 500;
    private BattleUnit[] army;

    public King(int healthScore) {
        super(healthScore);
    }

    // увеличивает золото на count, нет ограничений по максимуму
    public void plusGold(int count) {
        gold += count;
    }

    // уменьшает золото на count
    public void minusGold(int count) {
        if (gold < count) return; // если золота у короля меньше count, уменьшения не происходит
        gold -= count;
    }

    public void generateArmy() {
        if (gold < 250) { // если у короля нет достаточного количества золота, армия не может быть создана
            System.out.println("Недостаточно золота для создании армии");
            return;
        }
        minusGold(250); // стоимость армии - 250 золота
        army = BattleUnit.getBattleUnits(20);
        /* army = new BattleUnit[20];
         *//*for (int i = 0; i < 3; i++) { // три первых юнита в армии - рыцари (Knight)
            int healthScore = (int) (10 + Math.random() * 40);
            int attackScore = (int) (7 + Math.random() * 13);
            army[i] = new Knight(healthScore, attackScore);
        }

        for (int i = 3; i < army.length; i++) { // остальные юниты - пехотинцы (Infantry)
            int healthScore = (int) (10 + Math.random() * 40);
            int attackScore = (int) (7 + Math.random() * 13);
            army[i] = new Infantry(healthScore, attackScore);
        }*//*
        for (int i = 0; i < army.length; i++) {
            army[i] = BattleUnit.getBattleUnit();
        }*/
    }

    // заменяет погибших юнитов новыми юнитами
    public void changeUnits() {
        if (gold < 20) { // заменять можно, пока у короля хватает золота
            System.out.println("Стоимость одного юнита: 20. У короля " + gold);
            return;
        }
        for (int i = 0; i < army.length; i++) {
            if (gold < 20) { // заменять можно, пока у короля хватает золота
                System.out.println("Стоимость одного юнита: 20. У короля " + gold);
                return;
            }
            if (army[i] != null && !army[i].isAlive()) {
                minusGold(20); // стоимость одной замены - 20 золота
                army[i] = BattleUnit.getBattleUnit();
            }
        }
    }

    public void startBattle(King enemy) {
        //iter
        /*for (BattleUnit battleUnit : army) { }*/
        for (int i = 0; i < army.length; i++) {
            int unitIndex = (int)(Math.random()* army.length);
            int enemyUnitIndex = (int)(Math.random()*enemy.army.length);
            army[unitIndex].attack(enemy.army[enemyUnitIndex]);
            army[unitIndex].rest();
            enemy.army[enemyUnitIndex].rest();
            if(this.getBattleUnitsCount()>enemy.getBattleUnitsCount()) this.plusGold(50);
            else enemy.plusGold(50);
        }
    }


    // возвращает количество живых юнитов в армии
    public int getBattleUnitsCount() {
        int count = 0;
        for (BattleUnit battleUnit : army) {
            if (battleUnit.isAlive()) count += 1;
        }
        return count;
    }

    // реализация абстрактного метода
    @Override
    public void rest() {
        minusGold(50);
        plusHealth(5);
        System.out.println("Отдых короля");
    }


}
