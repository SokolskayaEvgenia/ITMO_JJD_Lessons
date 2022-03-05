package Lesson02;

public class SecondLesson {
    public static void main(String[] args) {
        //логические операторы
        /*


        //&& оператор и
        int x = 50, y = 100, z = 91;
        boolean res = (x % 2 == 0) && (y % 2 == 0) && (z % 2 == 0);
        // true && true && false
        //     true     && false
        System.out.println(res); // false

        res = (x < z) && (y > z);
        System.out.println(res); // true

        // || оператор или
        int code = 3333, age = 34;
        res = (code == 2222) || (code == 3333) || (code == 4444);
        // false || true || false
        //      true     || false
        System.out.println(res); // true
        res = (code != 3333) || (age < 18);
        // false || false
        System.out.println(res); //false

        // ! оператор не - ничего не сравнивает, меняет значение на противоположное
        System.out.println(!res); // true

        boolean isActive = false, isConnected = true;
        res = !isActive || !isConnected;
        // true || false
        System.out.println(res); // true

        res = !((code != 3333) || (age < 18));
        System.out.println(res); //true
        res = !(code != 3333) || (age < 18);
        System.out.println(res); //true


        int state = 1;
        if (state == 1) System.out.println("Открытие приложения");
        else if (state == 0) System.out.println("Закрытие приложения");
        else System.out.println("Ошибка статуса");
        */


        int month = 2;
        if (month >= 1 && month <= 12) {
            if (month >= 3 && month <= 5) System.out.println("Весна");
            else if (month >= 6 && month <= 8) System.out.println("Лето");
            else if (month >= 9 && month <= 11) System.out.println("Осень");
            else System.out.println("Зима");
        } else System.out.println("Ошибка ввода данных");

        if (month >= 1 && month <= 12) {
            if (month > 0 || month > 11) System.out.println("Зима");
            else if (month > 8) System.out.println("Осень");
            else if (month > 5) System.out.println("Лето");
            else System.out.println("Весна");
        } else System.out.println("Ошибка ввода данных");


        month = 1;
        switch (month) {
            case 1:
            case 2:
            case 12:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
            default:
                System.out.println("Ошибка ввода");
        }

        double sum = 1000;
        int saleCode = 4318;
        switch (saleCode){
            case 4525:
                sum = sum - sum*0.3;
                break;
            case 6424:
            case 7012:
                sum = sum - sum*0.2;
                break;
            case 7647:
            case 9011:
            case 6612:
                sum = sum - sum*0.1;
                break;
            default:
                System.out.println("Скидка не предусмотрена");
        }
        System.out.println(sum);
    }
}
