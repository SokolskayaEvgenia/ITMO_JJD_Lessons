package ru.itmo.lessons.lesson20.serialization;

public class Application {
    public static void main(String[] args) {
        Point a = new Point(45, 67);
        Point b = new Point(67, 12);
        Point c = new Point(89, -8);

        BinHandler binHandler = new BinHandler();
        binHandler.writeToFile(a);

        Point aFromFile = binHandler.readFromFile();
        System.out.println(aFromFile);

        Figure figure1 = new Figure(3);
        figure1.addPoint(a);
        figure1.addPoint(b);
        figure1.addPoint(c);

        BinHandler binHandler1 = new BinHandler();
        binHandler1.writeToFile(figure1);
        Figure figureFromFile = binHandler1.readFromFile();
        System.out.println(figureFromFile);
    }
}
