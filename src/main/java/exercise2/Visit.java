package exercise2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

public class Visit {

    private Doctor doctor;
    private Patient patient;
    private LocalDate dateOfVisit;

    public Visit(Doctor doctor, Patient patient, LocalDate dateOfVisit) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateOfVisit = dateOfVisit;
    }

    public static Visit assignVisitsToParticipants(String dataOfVisit, Map<String, Doctor> doctorMap, Map<String, Patient> patientMap) {
        String[] splitData = dataOfVisit.split("\t");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate visitDate = LocalDate.parse(splitData[2], formatter);

        Doctor doctor = getDoctorByID(Integer.parseInt(splitData[0]), doctorMap);
        Patient patient = getPatientByID(Integer.parseInt(splitData[1]), patientMap);

        if (doctor != null && patient != null) {
            Visit visit = new Visit(doctor, patient, visitDate);
            doctor.bookVisit(visit);
            patient.bookVisit(visit);
            return visit;
        }
        return null;
    }

    private static Doctor getDoctorByID(int iD, Map<String, Doctor> doctorMap) {
        for (Doctor doctor : doctorMap.values()) {
            if (doctor.getId() == iD) {
                return doctor;
            }
        }
        System.out.println("Nie znaleziono lekarza o podanym ID: " + iD);
        return null;
    }

    private static Patient getPatientByID(int iD, Map<String, Patient> patientMap) {
        for (Patient patient : patientMap.values()) {
            if (patient.getId() == iD) {
                return patient;
            }
        }
        System.out.println("Nie znaleziono pacjenta o podanym ID: " + iD);
        return null;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(doctor, visit.doctor) && Objects.equals(patient, visit.patient) && Objects.equals(dateOfVisit, visit.dateOfVisit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, patient, dateOfVisit);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "doctor=" + doctor +
                ", patient=" + patient +
                ", dateOfVisit=" + dateOfVisit +
                '}';
    }
}
