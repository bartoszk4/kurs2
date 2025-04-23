package exercise4;

import java.util.Objects;

public class Rectangle extends Figure {

    private int aSide;
    private int bSide;

    public Rectangle(int aSide, int bSide) {
        this.aSide = aSide;
        this.bSide = bSide;
    }

    public Rectangle(int index, int aSide, int bSide) {
        super(index);
        this.aSide = aSide;
        this.bSide = bSide;
    }

    public int getaSide() {
        return aSide;
    }

    public int getbSide() {
        return bSide;
    }

    @Override
    public double calculateArea() {
        return aSide * bSide;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * aSide + 2 * bSide;
    }

    @Override
    public String convertToCSV() {
        return super.convertToCSV() + aSide + "," + bSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return aSide == rectangle.aSide && bSide == rectangle.bSide;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aSide, bSide);
    }

    @Override
    public String toString() {
        return super.toString() + ": Prostokat o bokach " + aSide + "x" + bSide;

    }
}
