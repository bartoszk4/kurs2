package exercise1;

import Utils.FileHandler;

import java.time.DayOfWeek;
import java.util.*;

import static exercise1.Child.*;
import static Utils.ValidationUtils.*;

public class ChildUtils {

    public static List<Child> loadChildrenData(String pathname, Map<Integer, Mother> mothersMap) {
        Mother mother;
        Child child;
        List<Child> childList = new ArrayList<>();

        for (String singleChildFromList : FileHandler.readDataFromFile(pathname, false)) {
            child = createObjectOfChildFromData(singleChildFromList);
            mother = mothersMap.get(child.getMotherId());
            child.setMother(mother);
            mother.assignChildToMother(child);
            childList.add(child);
        }
        return childList;
    }

    public static Child getHighestChildByTheSex(List<Child> childrenList, Sex sex) {
        if (isInputDataNotValid(childrenList)) {
            return null;
        }
        Child highestChild = null;
        for (Child child : childrenList) {
            if (child.getSex() == sex && child.isTallerThan(highestChild)) {
                highestChild = child;
            }
        }
        if (highestChild == null) {
            System.out.println("Nie znaleziono dziecka o podanej płci!");
        }
        return highestChild;
    }

    private static Map<DayOfWeek, Integer> getCountsInDays(List<Child> childrenList) {
        Map<DayOfWeek, Integer> countsInDays = new HashMap<>();
        for (Child child : childrenList) {
            DayOfWeek dayOfBirth = child.getBirthday().getDayOfWeek();
            if (countsInDays.containsKey(dayOfBirth)) {
                int currentValue = countsInDays.get(dayOfBirth);
                countsInDays.put(dayOfBirth, ++currentValue);
            } else {
                countsInDays.put(dayOfBirth, 1);
            }
        }
        return countsInDays;
    }

    private static int getHighestBirthRateInOneDay(Map<DayOfWeek, Integer> countsInDays) {
        int highestBirthRateInOneDay = 0;
        for (DayOfWeek dayOfWeek : countsInDays.keySet()) {
            int count = countsInDays.get(dayOfWeek);
            if (count > highestBirthRateInOneDay) {
                highestBirthRateInOneDay = count;
            }
        }
        return highestBirthRateInOneDay;
    }

    private static Map<DayOfWeek, Integer> extractTopBirthRateDays(int highestBirthRateInOneDay, Map<DayOfWeek, Integer> countsInDays) {
        Map<DayOfWeek, Integer> daysWithHighestBirthRate = new HashMap<>();
        for (DayOfWeek dayOfWeek : countsInDays.keySet()) {
            int count = countsInDays.get(dayOfWeek);
            if (count == highestBirthRateInOneDay) {
                daysWithHighestBirthRate.put(dayOfWeek, count);
            }
        }
        return daysWithHighestBirthRate;
    }

    public static Map<DayOfWeek, Integer> getDaysOfWeekWithHighestBirthRate(List<Child> childrenList) {
        if (isInputDataNotValid(childrenList)) {
            return null;
        }
        Map<DayOfWeek, Integer> countsInDays = getCountsInDays(childrenList);
        int highestBirthRateInOneDay = getHighestBirthRateInOneDay(countsInDays);
        return extractTopBirthRateDays(highestBirthRateInOneDay, countsInDays);
    }

    private static List<Child> filterDaughtersNamedLikeMother(Map<Integer, Mother> mothersMap) {
        List<Child> qualifiedDaughters = new ArrayList<>();
        for (Mother mother : mothersMap.values()) {
            for (Child child : mother.getChildren()) {
                boolean isDaughter = child.getSex().equals(Sex.FEMALE);
                boolean isTheSameName = mother.getFirstName().equals(child.getFirstName());
                if (isDaughter && isTheSameName) {
                    qualifiedDaughters.add(child);
                }
            }
        }
        return qualifiedDaughters;
    }

    public static List<Child> getDaughtersWithTheSameNameAsMother(Map<Integer, Mother> mothersMap) {
        if (isInputDataNotValid(mothersMap)) {
            return Collections.emptyList();
        }
        List<Child> qualifiedDaughters = filterDaughtersNamedLikeMother(mothersMap);
        if (qualifiedDaughters.isEmpty()) {
            System.out.println("Brak córek spełniających założone wymogi");
            return Collections.emptyList();
        }
        return qualifiedDaughters;
    }

}
