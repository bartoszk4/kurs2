package exercise3;

import Utils.CSVUtils;
import Utils.FileHandler;

import java.util.ArrayList;
import java.util.List;

import static Utils.ValidationUtils.isInputDataNotValid;
import static exercise3.Person.*;

public class PersonUtils {

    public static Person[] loadPersonsData(String pathname) {
        List<Person> people = new ArrayList<>();
        Person singlePersonObject;
        for (String singlePersonFromList : FileHandler.readDataFromFile(pathname, false)) {
            singlePersonObject = createObjectOfPersonFromData(singlePersonFromList);
            people.add(singlePersonObject);
        }
        return people.toArray(new Person[0]);
    }

    public static Person getPersonWithHighestSalary(Person[] people) {
        if (isInputDataNotValid(people)) {
            return null;
        }
        double highestSalary = 0;
        double salary = 0;
        Person personWithHighestSalary = null;
        for (Person person : people) {
            salary = person.getSalary();
            if (salary > highestSalary) {
                highestSalary = salary;
                personWithHighestSalary = person;
            }
        }
        return personWithHighestSalary;
    }

    public static int countFemalesInGroup(Person[] people) {
        if (isInputDataNotValid(people)) {
            return 0;
        }
        int counter = 0;
        for (Person person : people) {
            if (person.isFemale()) {
                counter++;
            }
        }
        return counter;
    }

    public static void saveDataToCSV(String pathname, Person[] people) {
        CSVUtils.saveDataToCSV(pathname, people);
    }
}
