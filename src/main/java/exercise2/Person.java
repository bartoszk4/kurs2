package exercise2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Person {

    private int id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String PESELNumber;
    protected List<Visit> visits;

    public Person(int id, String lastName, String firstName, LocalDate birthDate, String PESELNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.PESELNumber = PESELNumber;
        this.visits = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPESELNumber() {
        return PESELNumber;
    }

    public void setPESELNumber(String PESELNumber) {
        this.PESELNumber = PESELNumber;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public int getVisitsCount() {
        return visits.size();
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", PESELNumber='" + PESELNumber + '\'' +
                '}';
    }
}
