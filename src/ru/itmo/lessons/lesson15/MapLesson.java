package ru.itmo.lessons.lesson15;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapLesson {

    public static void main(String[] args) {
        // Map хранят данные в парах ключ - значение
        /*
        Коллекции:
        элемент1
        элемент2
        элемент3
        элемент4

        Мапы:
        ключ1 - элемент1
        ключ2 - элемент2
        ключ3 - элемент3
        ключ4 - элемент4
         */

        // Особенности map:
        // 1. ключи мапы должны быть уникальны, значения не обязательно уникальны
        // 2. каждому ключу соответствует только одно значение
        // 3. Map не являются коллекциями

        // все мапы дженерики
        // наиболее популярные HashMap<K, V>, TreeMap<K, V>, EnumMap<K, V>, LinkedHashMap<K, V>

        // Особенности HashMap:
        // 1. хранит ключи в hash таблице (на основе hash кода)
        // 2. для ключей HashMap должны быть переопределены методы equals и hashCode
        // 2. обладает хорошей производительностью
        // 3. в качестве ключа можно использовать null
        // 4. порядок хранения элементов может отличаться от порядка добавления

        // создание экземпляра HashMap:
        // в <> сначала указываем типа данных ключей,
        // затем тип данных значений

        HashMap<String, Integer> hashMap = new HashMap<>();

        // добавление элементов
        hashMap.put("Москва", 790);
        hashMap.put("Ростов", 270);
        hashMap.put("Великий Новгород", 75);
        hashMap.put("Тверь", 12);
        hashMap.put(null, null); // null всегда на первом месте
        System.out.println(hashMap);

        // удаление пары
        hashMap.remove(null); // по ключу - удаление пары целиком
        hashMap.remove("Москва", 5); // по ключу и значению
        hashMap.remove("Ростов", 270); // по ключу и значению
        System.out.println(hashMap);

        // замена
        hashMap.replace("Великий Новгород", 100); // по ключу
        hashMap.replace("Тверь", 12, 22); // по ключу и значению
        System.out.println(hashMap);

        // получение значения по ключу
        System.out.println(hashMap.get("Тверь")); // не найдет - вернет null
        System.out.println(hashMap.get("Москва")); // не найдет - вернет null

        // если ключ не найден, вернет значение по умолчанию
        System.out.println(hashMap.getOrDefault("Санкт-Петербург", 0));
        System.out.println(hashMap.getOrDefault("Великий Новгород", 0));

        // проверить, содержится ли в мапе ключ - возвращает true or false
        System.out.println(hashMap.containsKey("Санкт-Петербург"));
        // проверить, содержится ли в мапе значение - возвращает true or false
        System.out.println(hashMap.containsValue(1000));

        System.out.println("---Перебор мап---");
        // hashMap.keySet(); // только ключи (Set)
        // hashMap.values(); // только значения (Collection)
        //   тип данных пары <тип данных ключа, тип данных значения> : у мапы вызываем метод entrySet
        for (Map.Entry<String, Integer> pair: hashMap.entrySet()){
            System.out.println("город (ключ): " + pair.getKey());
            System.out.println("количество покупателей (значение): " + pair.getValue());
        }

        // LinkedHashMap аналогична HashMap, но позволяет сохранять
        //порядок элементов (из-за чего менее производительна, чем HashMap)

        // Особенности EnumMap:
        // 1. использует перечисления (enum) в качестве ключей
        // 2. нельзя использовать null в качестве ключа, в кач-ве значения можно
        // 3. все ключи должны быть одного типа перечисления
        // 4. все значения содержит в массиве (размер массива - количество элементов перечисления)
        // 5. порядок хранения элементов соответствует порядку элементов enum
        // 6. для извлечения значений использует индекс ключа: values[key.ordinal()]

        // при создании объекта в конструктор необходимо передать ссылку на класс перечисления,
        // например, Role.class


        // Особенности TreeMap:
        // 1. хранит элементы в отсортированном по ключам порядке
        // 2. основан на красно-черном дереве
        // 3. null нельзя использовать в качестве ключей
        // 4. класс, объекты которого будут использоваться в качестве ключей должен реализовывать интерфейс Comparable
        // или в конструктор мапы необходимо передать Comparator

        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        treeMap.put("Анапа", 45);

        System.out.println(treeMap);




    }
}