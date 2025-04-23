package exercise3;

import java.util.Objects;

public class Worker extends Person {

    private String workstation;
    private double salary;

    public Worker(String firstName, String lastName, String PESELNumber, String city, String workstation, double salary) {
        super(firstName, lastName, PESELNumber, city);
        this.workstation = workstation;
        this.salary = salary;
    }

    public String getWorkstation() {
        return workstation;
    }

    public void setWorkstation(String workstation) {
        this.workstation = workstation;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String convertToCSV() {
        return super.convertToCSV() + "," + workstation + "," + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return Double.compare(salary, worker.salary) == 0 && Objects.equals(workstation, worker.workstation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workstation, salary);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Worker{" +
                "workstation='" + workstation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
