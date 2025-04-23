package exercise1;

import Utils.FileHandler;
import Utils.ValidationUtils;

import java.time.LocalDate;
import java.util.*;

import static exercise1.Mother.*;
import static Utils.ValidationUtils.isInputDataNotValid;

public class MotherUtils {

    public static Map<Integer, Mother> loadMothersData(String pathname) {
        Map<Integer, Mother> mothersMap = new HashMap<>();
        Mother mother;

        for (String singleMotherFromList : FileHandler.readDataFromFile(pathname, false)) {
            mother = createObjectOfMotherFromData(singleMotherFromList);
            mothersMap.put(mother.getId(), mother);
        }
        return mothersMap;
    }

    private static List<Mother> filterYoungMothersWithHeavyChildren(Map<Integer, Mother> mothersMap) {
        List<Mother> qualifiedMothers = new ArrayList<>();
        for (Mother mother : mothersMap.values()) {
            if (mother.getAge() < 25) {
                for (Child child : mother.getChildren()) {
                    if (child.getWeight() > 4000) {
                        qualifiedMothers.add(mother);
                        break;
                    }
                }
            }
        }
        return qualifiedMothers;
    }

    public static List<Mother> getMothersOfHeavyBabies(Map<Integer, Mother> mothersMap) {
        if (ValidationUtils.isInputDataNotValid(mothersMap)) {
            return Collections.emptyList();
        }
        List<Mother> qualifiedMothers = filterYoungMothersWithHeavyChildren(mothersMap);
        if (qualifiedMothers.isEmpty()) {
            System.out.println("Brak matek spełniających założone wymogi");
            return Collections.emptyList();
        }
        return qualifiedMothers;
    }

    private static Map<LocalDate, List<Child>> sortChildrenByDate(Mother mother) {
        Map<LocalDate, List<Child>> sortedChildrenByDate = new HashMap<>();
        for (Child child : mother.getChildren()) {
            if (sortedChildrenByDate.containsKey(child.getBirthday())) {
                sortedChildrenByDate.get(child.getBirthday()).add(child);
            } else {
                List<Child> childList = new ArrayList<>();
                childList.add(child);
                sortedChildrenByDate.put(child.getBirthday(), childList);
            }
        }
        return sortedChildrenByDate;
    }

    public static List<Mother> getMothersOfTwins(Map<Integer, Mother> mothersMap) {
        if (ValidationUtils.isInputDataNotValid(mothersMap)) {
            return Collections.emptyList();
        }
        List<Mother> qualifiedMothers = new ArrayList<>();
        for (Mother mother : mothersMap.values()) {
            Map<LocalDate, List<Child>> sortedChildrenByDate = sortChildrenByDate(mother);
            for (List<Child> childList : sortedChildrenByDate.values()) {
                if (childList.size() == 2) {
                    qualifiedMothers.add(mother);
                }
            }
        }
        if (qualifiedMothers.isEmpty()) {
            System.out.println("Brak matek spełniających założone wymogi");
            return Collections.emptyList();
        }
        return qualifiedMothers;
    }
}
