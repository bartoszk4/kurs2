package exercise4;

import java.util.Objects;

public class Square extends Figure {

    private int aSide;

    public Square(int aSide) {
        super();
        this.aSide = aSide;
    }

    public Square(int index, int aSide) {
        super(index);
        this.aSide = aSide;
    }

    public int getaSide() {
        return aSide;
    }

    @Override
    public double calculateArea() {
        return aSide * aSide;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * aSide;
    }

    @Override
    public String convertToCSV() {
        return super.convertToCSV() + aSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return aSide == square.aSide;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(aSide);
    }

    @Override
    public String toString() {
        return super.toString() + ": Kwadrat o boku " + aSide;

    }
}
