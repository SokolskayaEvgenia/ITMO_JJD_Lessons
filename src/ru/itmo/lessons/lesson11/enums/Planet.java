package ru.itmo.lessons.lesson11.enums;

public enum Planet {
    EARTH("Земля",30034896 , 6371.00),
    VENUS("Венера",24478383,6051.8),
    MARS("Марс", 32271514, 3389.508);

    Planet(String name, long weight, double radius){
        this.name = name;
        setWeight(weight);
        setRadius(radius);
    }

    private String name;
    private long weight;
    private double radius;

    public double getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }
}
