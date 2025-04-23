package exercise4;

import Utils.CSVConvertible;

public abstract class Figure implements Shape, CSVConvertible {

    private static int figuresCounter;
    private int index;

    public Figure(int index) {
        this.index = index;
    }

    public Figure() {
    }

    public static Rectangle createRectangle(int aSide, int bSide) {
        incrementFiguresCounter();
        return new Rectangle(figuresCounter, aSide, bSide);
    }

    public static Square createSquare(int aSide) {
        incrementFiguresCounter();
        return new Square(figuresCounter, aSide);
    }

    public static Circle createCircle(int radius) {
        incrementFiguresCounter();
        return new Circle(figuresCounter, radius);
    }

    public static Figure createObjectOfFigureFromData(String dataOfFigure) {
        String[] splitData = dataOfFigure.split(",");
        return switch (splitData[1]) {
            case "Circle" -> new Circle(Integer.parseInt(splitData[0]), Integer.parseInt(splitData[2]));
            case "Rectangle" ->
                    new Rectangle(Integer.parseInt(splitData[0]), Integer.parseInt(splitData[2]), Integer.parseInt(splitData[3]));
            case "Square" -> new Square(Integer.parseInt(splitData[0]), Integer.parseInt(splitData[2]));
            default -> null;
        };
    }

    private static void incrementFiguresCounter() {
        figuresCounter++;
    }

    public static int getFiguresCounter() {
        return figuresCounter;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String convertToCSV() {
        return getIndex() + "," + getClass().getSimpleName() + ",";
    }

    @Override
    public String toString() {
        return "Figura nr " + getIndex();
    }
}
