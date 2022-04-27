package ru.itmo.lessons.patterns.builder;

public class NutritionFacts {
    // обязательные параметры
    private final int servings;
    // необязательные параметры
    private final int calories;
    private final int fat;

    public static class Builder { // создает экземпляры NutritionFacts
        // обязательные парамерты
        private final int servings;
        // необязательные параметры, инициализируются
        // значениями по умолчанию
        private int calories = 1;
        private int fat;

        // значения обязательных устанавливаем через конструктор
        public Builder(int servings) {
            this.servings = servings;
        }

        // для остальных сеттеры
        public Builder calories(int caloriesVal){
            calories = caloriesVal; // изменение объекта
            return this; // возвращаем ссылку на текущий измененный объект
        }

        public Builder fat(int fatVal){
            fat = fatVal; // изменение объекта
            return this; // возвращаем ссылку на текущий измененный объект
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }


    private NutritionFacts(Builder builder){
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }


    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                '}';
    }
}