package exercise4;

import Utils.CSVUtils;
import Utils.FileHandler;

import java.util.ArrayList;
import java.util.List;

import static Utils.ValidationUtils.isInputDataNotValid;
import static exercise4.Figure.*;

public class FigureUtils {

    public static List<Figure> loadFiguresData(String pathname) {
        List<Figure> figures = new ArrayList<>();
        Figure singleFigureObject;
        for (String singlePersonFromList : FileHandler.readDataFromFile(pathname, false)) {
            singleFigureObject = createObjectOfFigureFromData(singlePersonFromList);
            figures.add(singleFigureObject);
        }
        return figures;
    }

    public static Figure getFigureWithBiggestArea(List<Figure> figures) {
        if (isInputDataNotValid(figures)) {
            return null;
        }
        double biggestArea = 0;
        double value;
        Figure figureWithBiggestArea = null;
        for (Figure figure : figures) {
            value = figure.calculateArea();
            if (value > biggestArea) {
                figureWithBiggestArea = figure;
                biggestArea = value;
            }
        }
        return figureWithBiggestArea;
    }

    public static Figure getFigureWithBiggestPerimeter(List<Figure> figures) {
        if (isInputDataNotValid(figures)) {
            return null;
        }
        double biggestPerimeter = 0;
        double value;
        Figure figureWithBiggestPerimeter = null;
        for (Figure figure : figures) {
            value = figure.calculatePerimeter();
            if (value > biggestPerimeter) {
                figureWithBiggestPerimeter = figure;
                biggestPerimeter = value;
            }
        }
        return figureWithBiggestPerimeter;
    }

    public static void saveDataToCSV(String pathname, List<Figure> figures) {
        CSVUtils.saveDataToCSV(pathname, figures);
    }
}
