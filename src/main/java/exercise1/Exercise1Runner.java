package exercise1;

import java.util.*;

public class Exercise1Runner {

    public static void main(String[] args) {

        final String mothersFilePathname = ("src/main/java/exercise1/files/mamy.txt");
        final String childrenFilePathname = ("src/main/java/exercise1/files/noworodki.txt");

        Map<Integer, Mother> motherMap = MotherUtils.loadMothersData(mothersFilePathname);
        List<Child> childList = ChildUtils.loadChildrenData(childrenFilePathname, motherMap);

        System.out.println("a) Podaj imię i wzrost najwyższego chłopca oraz imię i wzrost najwyższej dziewczynki.");
        Child highestMale = ChildUtils.getHighestChildByTheSex(childList, Sex.MALE);
        Child highestFemale = ChildUtils.getHighestChildByTheSex(childList, Sex.FEMALE);
        try {
            System.out.println(highestMale.getFirstName() + " " + highestMale.getHeight() + " cm");
        } catch (NullPointerException e) {
        }
        try {
            System.out.println(highestFemale.getFirstName() + " " + highestFemale.getHeight() + " cm");
        } catch (NullPointerException e) {
        }

        System.out.println("b) W którym dniu tygodnia urodziło się najwięcej dzieci? Podaj dzien tygodnia i liczbe dzieci.");
        System.out.println(ChildUtils.getDaysOfWeekWithHighestBirthRate(childList));

        System.out.println("c) Podaj imiona kobiet w wieku poniżej 25 lat, które urodziły dzieci o wadze powyżej 4000 g.");
        List<Mother> mothers = MotherUtils.getMothersOfHeavyBabies(motherMap);
        for (int i = 0; i < mothers.size(); i++) {
            System.out.println(mothers.get(i).getFirstName());
        }

        System.out.println("d) Podaj imiona i daty urodzenia dziewczynek, które odziedziczyły imię po matce.");
        List<Child> children = ChildUtils.getDaughtersWithTheSameNameAsMother(motherMap);
        for (int i = 0; i < children.size(); i++) {
            System.out.print(children.get(i).getFirstName() + " ");
            System.out.println(children.get(i).getBirthday());
        }

        System.out.println("e) Znajdz matki które urodziły bliźnięta.");
        List<Mother> mothers1 = MotherUtils.getMothersOfTwins(motherMap);
        for (int i = 0; i < mothers1.size(); i++) {
            System.out.println(mothers1.get(i).getFirstName());
        }
    }
}


