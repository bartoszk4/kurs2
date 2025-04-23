package exercise1;

import java.util.*;

public class Mother extends Person {

    private int age;
    private List<Child> children;

    public Mother(int index, String firstName, int age) {
        super(index, firstName);
        this.age = age;
        this.children = new ArrayList<>();
    }

    public static Mother createObjectOfMotherFromData(String dataOfMother) {
        String[] splitData = dataOfMother.split(" ");

        return new Mother(Integer.parseInt(splitData[0]),
                splitData[1],
                Integer.parseInt(splitData[2]));
    }

    public void assignChildToMother(Child child) {
        this.children.add(child);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Child> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mother mother = (Mother) o;
        return age == mother.age && Objects.equals(children, mother.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, children);
    }

    @Override
    public String toString() {
        return "Mother{" +
                super.toString() +
                ", age=" + age +
                (children != null ? (", children=" + Arrays.deepToString(children.toArray())) : "") +
                '}';
    }
}
