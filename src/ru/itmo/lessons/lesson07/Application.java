package ru.itmo.lessons.lesson07;

import ru.itmo.lessons.lesson07.base.BattleUnit;
import ru.itmo.lessons.lesson07.base.Unit;

public class Application {
    public static void main(String[] args) {
        //доступ ограничен типом данных и модификаторами доступа
        Knight knight1 = new Knight(20, 17);
        // можем вызвать методы Unit и BattleUnit, и Knight
        knight1.knightVoid();
        knight1.runFromField();

        BattleUnit knight2 = new Knight(20, 17);
        // можем вызвать методы Unit и BattleUnit, но не методы Knight
        knight2.battleUnitVoid();

        Unit knight3 = new Knight(20, 17);
        // можем вызвать методы Unit, но не методы Knight и BattleUnit
        knight3.plusHealth(20);


        Infantry infantry1 = new Infantry(18, 15);
        infantry1.runFromField();

    }
}
