package exercise3;

import Utils.CSVConvertible;

import java.util.*;

public abstract class Person implements CSVConvertible {

    private String firstName;
    private String lastName;
    private String PESELNumber;
    private String city;

    public Person(String firstName, String lastName, String PESELNumber, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PESELNumber = PESELNumber;
        this.city = city;
    }

    public static Person createObjectOfPersonFromData(String dataOfDoctor) {
        String[] splitData = dataOfDoctor.split(",");
        return switch (splitData[0]) {
            case "Student" ->
                    new Student(splitData[1], splitData[2], splitData[3], splitData[4], splitData[5], Double.parseDouble(splitData[6]));
            case "Worker" ->
                    new Worker(splitData[1], splitData[2], splitData[3], splitData[4], splitData[5], Double.parseDouble(splitData[6]));
            default -> null;
        };
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPESELNumber() {
        return PESELNumber;
    }

    public void setPESELNumber(String PESELNumber) {
        this.PESELNumber = PESELNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String convertToCSV() {
        return getClass().getSimpleName() + "," + firstName + "," + lastName + "," + PESELNumber + "," + city;
    }

    public abstract double getSalary();

    public boolean isPESELValid() {
        return PESELNumber != null && PESELNumber.length() == 11;
    }

    public void validatePESEL() {
        if (!isPESELValid()) {
            throw new IllegalArgumentException("Podano błędny PESEL");
        }
    }

    public int extractSexDigit() {
        validatePESEL();
        return Character.getNumericValue(PESELNumber.charAt(9));
    }

    public boolean isFemale() {
        return extractSexDigit() % 2 == 0;
    }

    public boolean isMale() {
        return extractSexDigit() % 2 != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(PESELNumber, person.PESELNumber) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, PESELNumber, city);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PESELNumber='" + PESELNumber + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
