package exercise4;

import java.util.Arrays;
import java.util.List;

public class Exercise4Runner {

    public static void main(String[] args) {

        List<Figure> figures = Arrays.asList(Figure.createSquare(10), Figure.createCircle(20), Figure.createRectangle(10, 20));
        Figure figure;

        for (Figure f : figures) {
            System.out.println(f);
        }

        try {
            figure = FigureUtils.getFigureWithBiggestArea(figures);
            System.out.println("Figura o największym polu wynoszącym: " + figure.calculateArea() + " to " + figure);
        } catch (NullPointerException e) {
        }

        try {
            figure = FigureUtils.getFigureWithBiggestPerimeter(figures);
            System.out.println("Figura o największym obwodzie wynoszącym: " + figure.calculatePerimeter() + " to " + figure);
        } catch (NullPointerException e) {
        }

        try {
            System.out.println(figures.contains(new Square(10)));
        } catch (NullPointerException e) {

        }

        Square square = new Square(50);
        System.out.println(square);

        final String saveDataPathname = ("src/main/java/exercise4/files/zapisaneDane.txt");
        FigureUtils.saveDataToCSV(saveDataPathname, figures);

        List<Figure> figuresFromFile = FigureUtils.loadFiguresData(saveDataPathname);
        try {
            if (figures.equals(figuresFromFile)) {
                System.out.println("Tablice są identyczne");
            }
        } catch (NullPointerException e) {
        }
    }
}
