package exercise2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Patient extends Person {

    private Set<Doctor> doctors;

    public Patient(int id, String lastName, String firstName, LocalDate birthDate, String PESELNumber) {
        super(id, lastName, firstName, birthDate, PESELNumber);
        this.doctors = new HashSet<>();
    }

    public static Patient createObjectOfPatientFromData(String dataOfPatient) {
        String[] splitData = dataOfPatient.split("\t");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate birthDate = LocalDate.parse(splitData[4], formatter);

        return new Patient(Integer.parseInt(splitData[0]),
                splitData[1],
                splitData[2],
                birthDate,      //data ur
                splitData[3]    //pesel
        );
    }

    public void addDoctorToDoctorsList(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void bookVisit(Visit visit) {
        addDoctorToDoctorsList(visit.getDoctor());
        visits.add(visit);
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(doctors, patient.doctors);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(doctors);
    }

    @Override
    public String toString() {
        return "Patient{" +
                super.toString() +
                "doctors=" + doctors +
                '}';
    }
}
