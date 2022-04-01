package ru.itmo.lessons.lesson13.types;

// тип Т будет определяться на моменте создания объекта
public class User<T> {

    private T id; /* внутри класса у свойства id
    можно вызвать только методы Object
    если у свойства генерик тип, то и в конструкторе,
    и в сеттерах-геттерах тот же генерик тип (то же буквенное обозначение)*/
    private String login;

    public void setId(T id){
        this.id = id;
    }
    public T getId(){
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
