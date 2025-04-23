package exercise2;

import java.time.Period;
import java.util.*;


public class Exercise2Runner {

    public static void main(String[] args) {

        final String doctorsFilePathname = ("src/main/java/exercise2/files/lekarze.txt");
        final String patientFilePathname = ("src/main/java/exercise2/files/pacjenci.txt");
        final String visitsFilePathname = ("src/main/java/exercise2/files/wizyty.txt");

        Map<String, Doctor> doctorMap = DoctorUtils.loadDoctorsData(doctorsFilePathname);
        Map<String, Patient> patientMap = PatientUtils.loadPatientsData(patientFilePathname);
        List<Visit> visitList = VisitUtils.loadVisits(visitsFilePathname, doctorMap, patientMap);

        System.out.println("--------------------znajdź lekarza ktory miał najwięcej wizyt--------------------");
        List<Doctor> doctorList = DoctorUtils.getDoctorsWithMostVisits(doctorMap);
        for (int i = 0; i < doctorList.size(); i++) {
            System.out.println("Imię= " + doctorList.get(i).getFirstName() + ", ID= " + doctorList.get(i).getId() + ", liczba wizyt= " + doctorList.get(i).getVisits().size());
        }

        System.out.println("--------------------znajdź pacjenta ktory miał najwięcej wizyt--------------------");
        List<Patient> patientList = PatientUtils.getPatientsWithMostVisits(patientMap);
        for (int i = 0; i < patientList.size(); i++) {
            System.out.println("Imię= " + patientList.get(i).getFirstName() + ", ID= " + patientList.get(i).getId() + ", liczba wizyt= " + patientList.get(i).getVisits().size());
        }

        System.out.println("--------------------która specalizacja cieszy się największym powodzeniem?--------------------");
        Map<String, Integer> mostPopularSpecialization = DoctorUtils.getMostPopularSpecializations(doctorMap);
        for (String specialization : mostPopularSpecialization.keySet()) {
            int value = mostPopularSpecialization.get(specialization);
            System.out.println("Specjalizacja " + specialization + " bylo " + value);
        }

        System.out.println("--------------------którego roku było najwięcej wizyt?--------------------");
        Map<Integer, Integer> yearsWithMostVisits = VisitUtils.getYearsWithMostVisits(visitList);
        for (int year : yearsWithMostVisits.keySet()) {
            int value = yearsWithMostVisits.get(year);
            System.out.println("W roku " + year + " bylo " + value);
        }

        System.out.println("--------------------wypisz top 5 najstarszych lekarzy--------------------");
        Map<Period, List<Doctor>> fiveOldestDoctors = DoctorUtils.getFiveOldestDoctors(doctorMap);
        for (Period period : fiveOldestDoctors.keySet()) {
            System.out.print("Wiek lekarza: " + period.getYears() + " lat " + period.getMonths() + " miesięcy " + period.getDays() + " dni. ");
            for (Doctor doctor : fiveOldestDoctors.get(period)) {
                System.out.println(doctor);
            }
        }

        System.out.println("--------------------wypisz top 5 lekarzy co mieli najwiecej wizyt--------------------");
        Map<Integer, List<Doctor>> fiveDoctorsWithMostVisits = DoctorUtils.getFiveDoctorsWithMostVisits(doctorMap);
        for (int value : fiveDoctorsWithMostVisits.keySet()) {
            System.out.print("Liczba wizyt: " + value + ", lista lekarzy: ");
            for (Doctor doctor : fiveDoctorsWithMostVisits.get(value)) {
                System.out.println(doctor);
            }
        }

        System.out.println("--------------------zwroc pacientow ktorzy byli u minumum 5ciu roznych lekarzy--------------------");
        Map<Integer, List<Patient>> patientsWithAtLeastFiveDifferentDoctors = PatientUtils.getPatientsWithAtLeastFiveDifferentDoctors(patientMap);
        for (int value : patientsWithAtLeastFiveDifferentDoctors.keySet()) {
            for (Patient patient : patientsWithAtLeastFiveDifferentDoctors.get(value)) {
                System.out.println("Pacjent " + patient.getFirstName() + ", ID " + patient.getId() + ", liczba lekarzy " + value);
            }
        }

        System.out.println("--------------------zwroc lekarzy ktorzy przyjeli tylko jednego pacjenta--------------------");
        List<Doctor> doctorList2 = DoctorUtils.getDoctorsWithOnlyOnePatient(doctorMap);
        for (Doctor doctor : doctorList2) {
            System.out.println("Imię lekarza: " + doctor.getFirstName() + ", ID: " + doctor.getId());
        }
    }
}

