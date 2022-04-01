package ru.itmo.lessons.lesson13.types;

public class TypesApp {
    public static void main(String[] args) {
        User<String> stringUser = new User<>(); // если не указан <тип>, то работаем с Object
        stringUser.setId("fr25425");
        stringUser.setLogin("qwerty");

        String sId = stringUser.getId();
        System.out.println(sId.contains("fr"));

        User<Integer> integerUser = new User<>(); // нельзя указать <int>, генерики не работают с примитивами
        integerUser.setId(1);
        integerUser.setLogin("asd");

        Integer iId = integerUser.getId();
        System.out.println(iId > 0);

        /*public class PairContainer<T (key), K (value)>*/
        PairContainer<String, Integer> container1 = new PairContainer<>("a", 1);
        System.out.println(container1.getKey()); // String
        System.out.println(container1.getValue()); // Integer

        PairContainer<String, User> container2 = new PairContainer<>("x", stringUser); // если передали User без конкретики,
        // то container вытаскивает его как Object
        Object oId = container2.getValue().getId();

        PairContainer<String, User<String>> container3 = new PairContainer<>("y", stringUser);
        String strId = container3.getValue().getId();

        // PairContainer, ключ - Integer, значение PairContainer,
        // где ключ Integer, значение User,
        // у которого id Integer

        PairContainer<Integer, User<Integer>> container4 = new PairContainer<>(1, integerUser);
        PairContainer<Integer, PairContainer<Integer, User<Integer>>> container5 = new PairContainer<>(2, container4);
        PairContainer<Integer, PairContainer<Integer, User<Integer>>> container6 = new PairContainer<>(3, new PairContainer<>(4, integerUser));
    }
}
