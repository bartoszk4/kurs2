package exercise2;

import Utils.FileHandler;

import java.util.*;

import static Utils.ValidationUtils.*;
import static exercise2.Patient.*;

public class PatientUtils {

    public static Map<String, Patient> loadPatientsData(String pathname) {
        Map<String, Patient> patientsMap = new HashMap<>();
        for (String singlePatientsFromList : FileHandler.readDataFromFile(pathname, true)) {
            Patient singlePatientObject = createObjectOfPatientFromData(singlePatientsFromList);
            if (!patientsMap.containsKey(singlePatientObject.getPESELNumber())) {
                patientsMap.put(singlePatientObject.getPESELNumber(), singlePatientObject);
            }
        }
        return patientsMap;
    }

    public static List<Patient> getPatientsWithMostVisits(Map<String, Patient> patientMap) {
        if (isInputDataNotValid(patientMap)) {
            return null;
        }
        List<Patient> patientList = new ArrayList<>();
        int highestVisitsCount = 0;
        for (Patient patient : patientMap.values()) {
            if (patient.getVisitsCount() > highestVisitsCount) {
                highestVisitsCount = patient.getVisits().size();
            }
        }
        for (Patient patient : patientMap.values()) {
            if (patient.getVisitsCount() == highestVisitsCount) {
                patientList.add(patient);
            }
        }
        return patientList;
    }

    public static Map<Integer, List<Patient>> getPatientsWithAtLeastFiveDifferentDoctors(Map<String, Patient> patientMap) {
        if (isInputDataNotValid(patientMap)) {
            return null;
        }
        Map<Integer, List<Patient>> result = new LinkedHashMap<>();
        int numberOfDoctors;
        for (Patient patient : patientMap.values()) {
            numberOfDoctors = patient.getDoctors().size();
            if (numberOfDoctors >= 5) {
                result.computeIfAbsent(numberOfDoctors, k -> new ArrayList<>()).add(patient);
            }
        }
        if (result.isEmpty()){
            System.out.println("Lista jest pusta");
        }
        return result;
    }

}
