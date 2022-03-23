package ru.itmo.lessons.lesson09;

import java.util.Arrays;

public final class Figure {
    private final Point[] points; // не можем переписать ссылку points,
    // внутри с объектом можем делать все, что хотим

    public Figure(int pointCount) {
        if (pointCount < 2) {
            throw new IllegalArgumentException("Фигура должна состоять минимум из двух точек");
        }
        this.points = new Point[pointCount];
    }

    // метод добавления точки в массив
    // одинаковые точки добавлять нельзя
    public void addPoint(Point point) {
        if (point == null) throw new IllegalArgumentException("Такой точки нет");
        for (int i = 0; i < points.length; i++) {
            if (points[i] != null && points[i].equals(point)) {
                System.out.println("Точка " + point + " не была добавлена. " +
                        "Можно добавлять только разные точки.");
                return;
            }
            if (points[i] == null) {
                points[i] = point;
                return;
            }
        }
        System.out.println("Точка " + point + " не была добавлена. У фигуры достаточное кол-во точек.");

    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Arrays.equals(points, figure.points); //метод equals у точек должен быть переопределен
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    @Override
    // если ссылочные типы, то реализация метода родителя не подойдет
    public Figure clone() {
        Figure copy = new Figure(this.points.length);
        for (int i = 0; i < this.points.length; i++) {
            copy.points[i] = this.points[i].clone();
        }
        return copy;
    }
}
