package exercise3;


import java.util.Arrays;

public class Exercise3Runner {

    public static void main(String[] args) {

        Student student1 = new Student("Jan", "Kowalski", "97062504652", "Gdynia", "Informatyczna", 1200);
        Student student2 = new Student("Tomasz", "Bagiński", "70011345567", "Warszawa", "Plastyczna", 1300);

        Worker worker1 = new Worker("Monika", "Kadaj", "70111133456", "Poznań", "pakowacz", 4500);
        Worker worker2 = new Worker("Karolina", "Jaworska", "54092365792", "Olsztyn", "lakiernik", 3900);

        Person[] people = new exercise3.Person[]{
                student1, student2, worker1, worker2
        };

        System.out.println("--------------------znajdz osobe z najwiekszym dochodem--------------------");
        System.out.println(PersonUtils.getPersonWithHighestSalary(people));

        System.out.println("--------------------policz ile jest kobiet w tablicy--------------------");
        System.out.println(PersonUtils.countFemalesInGroup(people));

        final String savePathname = ("src/main/java/exercise3/files/zapisaneDane.txt");
        PersonUtils.saveDataToCSV(savePathname, people);
        Person[] peopleFromFile = PersonUtils.loadPersonsData(savePathname);
        if (Arrays.equals(people, peopleFromFile)) {
            System.out.println("Tablice są identyczne");
        }
    }
}
