package exercise2;

import Utils.FileHandler;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import static Utils.ValidationUtils.*;
import static exercise2.Doctor.*;

public class DoctorUtils {

    public static Map<String, Doctor> loadDoctorsData(String pathname) {
        Map<String, Doctor> doctorsMap = new HashMap<>();
        for (String singleDoctorsFromList : FileHandler.readDataFromFile(pathname, true)) {
            Doctor singleDoctorObject = createObjectOfDoctorFromData(singleDoctorsFromList);
            if (!doctorsMap.containsKey(singleDoctorObject.getNIPNumber())) {
                doctorsMap.put(singleDoctorObject.getNIPNumber(), singleDoctorObject);
            }
        }
        return doctorsMap;
    }

    public static List<Doctor> getDoctorsWithMostVisits(Map<String, Doctor> doctorMap) {
        if (isInputDataNotValid(doctorMap)) {
            return null;
        }
        List<Doctor> doctorList = new ArrayList<>();
        int highestVisitsCount = 0;
        for (Doctor doctor : doctorMap.values()) {
            if (doctor.getVisitsCount() > highestVisitsCount) {
                highestVisitsCount = doctor.getVisitsCount();
            }
        }
        for (Doctor doctor : doctorMap.values()) {
            if (doctor.getVisitsCount() == highestVisitsCount) {
                doctorList.add(doctor);
            }
        }
        return doctorList;
    }

    private static Map<String, Integer> getSpecializationsCounts(Map<String, Doctor> doctorMap) {
        Map<String, Integer> specializationsCounts = new HashMap<>();
        for (Doctor doctor : doctorMap.values()) {
            String specialization = doctor.getSpecialization();
            if (specializationsCounts.containsKey(specialization)) {
                int currentValue = specializationsCounts.get(specialization);
                specializationsCounts.put(specialization, ++currentValue);
            } else {
                specializationsCounts.put(specialization, 1);
            }
        }
        return specializationsCounts;
    }

    private static int getMostPopularSpecializationCount(Map<String, Integer> specializationsCounts) {
        int countMax = 0;
        for (int value : specializationsCounts.values()) {
            if (value > countMax) {
                countMax = value;
            }
        }
        return countMax;
    }

    public static Map<String, Integer> getMostPopularSpecializations(Map<String, Doctor> doctorMap) {
        if (isInputDataNotValid(doctorMap)) {
            return null;
        }
        Map<String, Integer> specializationsCounts = getSpecializationsCounts(doctorMap);
        int countMax = getMostPopularSpecializationCount(specializationsCounts);
        Map<String, Integer> topSpecializations = new HashMap<>();
        int currentValue;
        for (String specialization : specializationsCounts.keySet()) {
            currentValue = specializationsCounts.get(specialization);
            if (currentValue == countMax) {
                topSpecializations.put(specialization, currentValue);
            }
        }
        return topSpecializations;
    }

    public static Map<Period, List<Doctor>> getFiveOldestDoctors(Map<String, Doctor> doctorMap) {
        if (isInputDataNotValid(doctorMap)) {
            return null;
        }
        List<Doctor> doctorList = new ArrayList<>(doctorMap.values());
        doctorList.sort(Doctor::compareAge);
        Map<Period, List<Doctor>> result = new LinkedHashMap<>();
        Period period;
        Doctor doctor;
        for (int i = 0; i < 5 && i < doctorList.size(); i++) {
            doctor = doctorList.get(i);
            period = Period.between(doctor.getBirthDate(), LocalDate.now());
            if (!result.containsKey(period)) {
                result.put(period, new ArrayList<>());
            }
            result.get(period).add(doctor);
        }
        return result;
    }

    public static Map<Integer, List<Doctor>> getFiveDoctorsWithMostVisits(Map<String, Doctor> doctorMap) {
        if (isInputDataNotValid(doctorMap)) {
            return null;
        }
        List<Doctor> doctorList = new ArrayList<>(doctorMap.values());
        doctorList.sort(Doctor::compareVisitsCount);
        Map<Integer, List<Doctor>> result = new LinkedHashMap<>();
        int visits;
        Doctor doctor;
        for (int i = 0; i < 5 && i < doctorList.size(); i++) {
            doctor = doctorList.get(i);
            visits = doctor.getVisitsCount();
            if (!result.containsKey(visits)) {
                result.put(visits, new ArrayList<>());
            }
            result.get(visits).add(doctor);
        }
        return result;
    }

    public static List<Doctor> getDoctorsWithOnlyOnePatient(Map<String, Doctor> doctorMap) {
        if (isInputDataNotValid(doctorMap)) {
            return null;
        }
        List<Doctor> result = new ArrayList<>();
        for (Doctor doctor : doctorMap.values()) {
            if (doctor.getPatients().size() == 1) {
                result.add(doctor);
            }
        }
        if (result.isEmpty()){
            System.out.println("Lista jest pusta");
        }
        return result;
    }
}
