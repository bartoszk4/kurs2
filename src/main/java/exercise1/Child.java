package exercise1;

import java.time.LocalDate;
import java.util.Objects;

public class Child extends Person {

    private Sex sex;
    private LocalDate birthday;
    private int weight;
    private int height;
    private Mother mother;

    public Child(int index, String firstName, Sex sex, LocalDate birthday, int weight, int height, Mother mother) {
        super(index, firstName);
        this.sex = sex;
        this.birthday = birthday;
        this.weight = weight;
        this.height = height;
        setMother(mother);
    }

    public static Child createObjectOfChildFromData(String dataOfChild, Mother mother) {
        String[] splitData = dataOfChild.split(" ");

        return new Child(Integer.parseInt(splitData[0]),
                splitData[2],
                Sex.decodeSex(splitData[1]),
                LocalDate.parse(splitData[3]),
                Integer.parseInt(splitData[4]),
                Integer.parseInt(splitData[5]),
                mother
        );
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public boolean isTallerThan(Child other) {
        return (other != null ? this.height > other.height : true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return weight == child.weight && height == child.height && sex == child.sex && Objects.equals(birthday, child.birthday) && Objects.equals(mother, child.mother);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex, birthday, weight, height, mother);
    }

    @Override
    public String toString() {
        return "Child{" +
                super.toString() +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", weight=" + weight +
                ", height=" + height +
                (mother != null ? (", motherName=" + mother.getFirstName()) : "") +
                (mother != null ? (", motherAge=" + mother.getAge()) : "") +
                '}';
    }
}
