package ru.itmo.lessons.lesson15;

import ru.itmo.lessons.lesson14.Student;

import java.util.*;

public class MapApp {
    public static void main(String[] args) {
        // TODO: ЗАДАЧИ
        //  1. Создать несколько экземпляров класса User с повторяющимися значениями свойства age
        //  2. Создать HashMap, где ключи - логины пользователей,
        //  значения - экземпляры класса User
        //  3. Добавить данные
        //  4. Логины всех пользователей, старше 20 лет скопировать в отдельный List
        //  5. Вывести логины и пароли пользователей с ролью ADMIN
        //  6. На основе существующей мапы создать новую, где ключи - возраст пользователей
        //  значения - списки пользователей соответствующего возраста

        User user1 = new User("Harry", "123", Role.ADMIN, 20);
        User user2 = new User("Hermione", "456", Role.ADMIN, 20);
        User user3 = new User("Ron", "789", Role.ADMIN, 20);
        User user4 = new User("Hagrid", "987", Role.USER, 40);
        User user5 = new User("Ginny", "654", Role.USER, 18);
        User user6 = new User("Snape", "321", Role.USER, 45);

        HashMap<String, User> userHashMap = new HashMap<>();

        userHashMap.put(user1.getLogin(), user1); // Entry(key, value)
        userHashMap.put(user2.getLogin(), user2); // Entry(key, value)
        userHashMap.put(user3.getLogin(), user3); // Entry(key, value)
        userHashMap.put(user4.getLogin(), user4); // Entry(key, value)
        userHashMap.put(user5.getLogin(), user5); // Entry(key, value)
        userHashMap.put(user6.getLogin(), user6); // Entry(key, value)

        // [
            // Entry(key, value)
            // Entry(key, value)
            // Entry(key, value)
            // Entry(key, value)
            // Entry(key, value)
            // Entry(key, value)
        // ]

        ArrayList<String> userLogins = new ArrayList<>();
        HashMap<Integer, ArrayList<User>> listHashMap = new HashMap<>();

        for (Map.Entry<String,User> pair : userHashMap.entrySet()) {
            if(pair.getValue().getAge()>20) userLogins.add(pair.getKey());
            if(pair.getValue().getRole() == Role.ADMIN) System.out.println("Login: " + pair.getKey() + ", password: "+ pair.getValue().getPwd());
        }

        System.out.println(userLogins);

        for (User user : userHashMap.values()) {
            if(!listHashMap.containsKey(user.getAge())) {
                ArrayList<User> users = new ArrayList<>();
                users.add(user);
                listHashMap.put(user.getAge(), users);
            }
            else  {
                listHashMap.get(user.getAge()).add(user);
            }
        }
        System.out.println(listHashMap);

        // TODO: ЗАДАЧИ
        //  1. Создать несколько экземпляров класса User
        //  2. Создать EnumMap, где ключи - роли, значения - списки пользователей
        //  3. Добавить данные
        //  4. Вывести в консоль логины всех пользователей с ролью USER
        //  5. Создать еще один экземпляр класса User, добавить его в мапу,
        //  представляя, что роль пользователя Вам неизвестна

        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);
        // [ArrayList, ArrayList]

        ArrayList<User> userAdmins = new ArrayList<>(Arrays.asList(user1,user2, user3));
        ArrayList<User> userUsers = new ArrayList<>(Arrays.asList(user4,user5, user6));
        enumMap.put(Role.ADMIN,userAdmins);
        enumMap.put(Role.USER, userUsers);
        for (User user : enumMap.get(Role.USER)) {
            System.out.println(user.getLogin());
        }

        User user7 = new User("Albus","0123456", Role.ADMIN, 125);
        enumMap.get(user7.getRole()).add(user7);
    }
}
