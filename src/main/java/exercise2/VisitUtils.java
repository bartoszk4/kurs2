package exercise2;

import Utils.FileHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Utils.ValidationUtils.*;
import static exercise2.Visit.*;

public class VisitUtils {

    public static List<Visit> loadVisits(String pathname, Map<String, Doctor> doctorMap, Map<String, Patient> patientMap) {
        List<Visit> visitList = new ArrayList<>();
        for (String singleVisitFromList : FileHandler.readDataFromFile(pathname, true)) {
            Visit visit = assignVisitsToParticipants(singleVisitFromList, doctorMap, patientMap);
            if (visit != null) {
                visitList.add(visit);
            }
        }
        return visitList;
    }

    public static Map<Integer, Integer> getYearsWithMostVisits(List<Visit> visits) {
        if (isInputDataNotValid(visits)) {
            return null;
        }
        Map<Integer, Integer> sortedVisitsByYear = sortVisitsByYear(visits);
        int countMax = 0;
        for (int value : sortedVisitsByYear.values()) {
            if (value > countMax) {
                countMax = value;
            }
        }
        Map<Integer, Integer> yearsWithMostVisits = new HashMap<>();
        int currentValue;
        for (int value : sortedVisitsByYear.keySet()) {
            currentValue = sortedVisitsByYear.get(value);
            if (currentValue == countMax) {
                yearsWithMostVisits.put(value, currentValue);
            }
        }
        return yearsWithMostVisits;
    }

    private static Map<Integer, Integer> sortVisitsByYear(List<Visit> visits) {
        Map<Integer, Integer> yearsWithMostVisits = new HashMap<>();
        int currentValue;
        int year;
        for (Visit visit : visits) {
            year = visit.getDateOfVisit().getYear();
            if (yearsWithMostVisits.containsKey(year)) {
                currentValue = yearsWithMostVisits.get(year);
                yearsWithMostVisits.put(year, ++currentValue);
            } else {
                yearsWithMostVisits.put(year, 1);
            }
        }
        return yearsWithMostVisits;
    }

}
