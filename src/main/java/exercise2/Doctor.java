package exercise2;

import java.time.LocalDate;
import java.util.*;

public class Doctor extends Person {

    private String specialization;
    private String NIPNumber;
    private Set<Patient> patients;

    public Doctor(int id, String lastName, String firstName, LocalDate birthDate, String PESELNumber, String specialization, String NIPNumber) {
        super(id, lastName, firstName, birthDate, PESELNumber);
        this.specialization = specialization;
        this.NIPNumber = NIPNumber;
        this.patients = new HashSet<>();
    }

    public static Doctor createObjectOfDoctorFromData(String dataOfDoctor) {
        String[] splitData = dataOfDoctor.split("\t");
        LocalDate birthDate = LocalDate.parse(splitData[4]);

        return new Doctor(Integer.parseInt(splitData[0]),
                splitData[1],
                splitData[2],
                birthDate,      //data ur
                splitData[6],   //pesel
                splitData[3],   //specja
                splitData[5]    //nip
        );
    }

    public void addPatientToPatientsList(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void bookVisit(Visit visit) {
        addPatientToPatientsList(visit.getPatient());
        visits.add(visit);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getNIPNumber() {
        return NIPNumber;
    }

    public void setNIPNumber(String NIPNumber) {
        this.NIPNumber = NIPNumber;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public int compareAge(Doctor other) {
        return this.getBirthDate().compareTo(other.getBirthDate());
    }

    public int compareVisitsCount(Doctor other) {
        return Integer.compare(other.getVisitsCount(), this.getVisitsCount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(specialization, doctor.specialization) && Objects.equals(NIPNumber, doctor.NIPNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialization, NIPNumber);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                super.toString() +
                ", specialization='" + specialization + '\'' +
                ", NIPNumber='" + NIPNumber + '\'' +
                '}';
    }

}
